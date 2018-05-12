/*
 * Copyright 2018 Kiss Dávid.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycompany.flokeszownengine.DB;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;
/**
 * @author Dávid
 */
@Slf4j
public class DataBase {
    /**
     * Osztalyelem peldanyositasa.
     */
    private static final DataBase DB_PELDANY = new DataBase();
    /**
     * Az adatbazis neve.
     */
    @PersistenceContext(unitName = "FlokeszDB")
    /**
     * EntityManager letrehozasa.
     */
    private EntityManager em;

    /**
     * Privát konstruktor.
     */
    private DataBase() {
    }

    /**
     * Aktiális DB szingleton példány lekérése.
     *
     * @return singleton példány referencia
     */
    public static DataBase getDbPeldany() {
        return DB_PELDANY;
    }

    /**
     * Adatbáziskapcsolat létrehozása JPA-val.
     *
     * @throws Exception JPA hiba esetén
     */
    public void connectDB() throws Exception {
        //persistence.xml-ben fontos, hogy megegyezzen a persistence-unit name ezzel, jelen esetben 'database'
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("FlokeszDB");
        em = emFactory.createEntityManager();
        log.trace("Adatbázis kapcsolat OK.");
    }

    /**
     * Adatbáziskapcsolat lezárása JPA-val.
     */
    public void disconnectDB() {
        if (connected()) {
            em.close();
            log.trace("Disconnect OK.");
        }
        em = null;
    }

    /**
     * EntityManager él és csatlakoztatva van az adatbázishoz?
     *
     * @return true -> igen
     */
    public boolean connected() {

        return em != null && em.isOpen();
    }

    /**
     * @param entity menteni kíván entitás
     *
     * @return mentett entitás (nem lenne feltétlenül szükséges, lehetne akár
     * void is, viszont hibaellenőrzéshez tök jó szerintem)
     *
     * @throws IllegalStateException ha nincs adatbázis-kapcsolat
     * @throws IllegalArgumentException ha a menteni kívánt film címe
     * érvénytelen ({@code null})
     * @throws Exception JPA hiba esetén
     */
    public JPAEntity save(JPAEntity entity) throws IllegalStateException, IllegalArgumentException, Exception {

        if (!connected()) {
            throw new IllegalStateException("Nincs adatbázis-kapcsolat!");
        }

        if (entity == null) {
            throw new IllegalArgumentException("A mentendő entitás null!");
        }

        try {
            em.getTransaction().begin();

            if (entity.getId() == null) {
                em.persist(entity);  //új entitás --> persist (insert)
            } else {
                em.merge(entity);    //módosítás --> merge (update)
            }

            em.getTransaction().commit();

            return entity;
        } catch (PersistenceException e) {

            log.error("JPA lekérdezési hiba!");
            throw new Exception("JPA hiba!", e);
        }
    }

    /**
     * Entitás törlése az adatbázisból.
     *
     * @param entity törlendő entitás
     *
     * @throws IllegalStateException ha nincs adatbázis-kapcsolat
     * @throws IllegalArgumentException ha a törlendő entitás null vagy nincs
     * {@code ID}-ja
     * @throws Exception JPA hiba esetén
     */
    public void delete(JPAEntity entity) throws IllegalStateException, IllegalArgumentException, Exception {
        if (!connected()) {
            throw new IllegalStateException("Nincs adatbázis-kapcsolat!");
        }

        if (entity == null || entity.getId() == 0) {
            throw new IllegalArgumentException("A törlendő entitás null vagy nincs ID-je!");
        }

        try {
            //a törlés előtt kikeresem az entitást, hogy biztosan Managed legyen
            JPAEntity delEntity = em.find(JPAEntity.class, entity.getId());

            if (delEntity.getId() == null) {
                throw new IllegalArgumentException("A törlendő score nem található az adatbázisban!");
            }

            em.getTransaction().begin();
            em.remove(delEntity);
            em.getTransaction().commit();

        } catch (PersistenceException e) {
            log.error("JPA lekérdezési hiba!");
            throw new Exception("JPA hiba", e);
        }
    }

//---------------------------------------------------------
//---------------------NamedQueries------------------------
//---------------------------------------------------------

    /**
     * Az osszes score lekerese csokkeno sorrendben.
     * @return Scoreokat tartalmazo lista
     * @throws IllegalStateException Ha nem jo az adatbazis.
     * @throws Exception Egyeb kivietel.
     */
    public List<JPAEntity> getAllOrderedByScore() throws IllegalStateException, Exception {

        if (!connected()) {
            throw new IllegalStateException("Nincs adatbázis-kapcsolat!");
        }
            @SuppressWarnings("unchecked")
            List<JPAEntity> lista = (List<JPAEntity>) em.createNamedQuery("JPAEntity.getAllOrderedByScore").getResultList();
            return lista;
    }
    /**
     * Vissza adja a HighScore-okat tartalmazo listat.
     * @return Azert lista, mert egyszerre tobb ugyan olyan score lehet.
     * @throws IllegalStateException ha adatbazis kapcsolat nincs.
     * @throws Exception egyeb kivetelek elkapasa
     */
    public List<Integer> getHighScore () throws  IllegalStateException, Exception{
         if (!connected()) {
            throw new IllegalStateException("Nincs adatbázis-kapcsolat!");
        }
         @SuppressWarnings("unchecked")
         List<Integer> lista = (List<Integer>) em.createNamedQuery("JPAEntity.getHighScore").getResultList();
         return lista;
    }
}
