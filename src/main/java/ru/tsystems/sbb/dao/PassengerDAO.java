package ru.tsystems.sbb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.TrainPO;

public class PassengerDAO extends AbstractDAO<PassengerPO> {
    public PassengerPO getPassengerByName(String passengerName, String passengerSurname) {
        Session session = sessions.openSession();
        PassengerPO passenger = null;

        try {
            Query query = session.createQuery("select p"
                    + "  from PassengerPO p"
                    + " where p.name = :name and p.surname = :surname")
                    .setString("name", passengerName)
                    .setString("surname", passengerSurname);

            passenger = (PassengerPO) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return passenger;
    }
}
