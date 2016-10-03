package ru.tsystems.sbb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.util.Date;
import java.util.List;

public class TrainDAO extends AbstractDAO<TrainPO> {
    public TrainPO getTrainByNumber(String trainNumber) {
        Session session = sessions.openSession();
        TrainPO train = null;

        try {
            Query query = session.createQuery("select tr"
                    + "  from TrainPO tr"
                    + " where tr.number = :train_number")
                    .setString("train_number", trainNumber);

            train = (TrainPO) query.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return train;
    }

    public List<PassengerPO> getPassengersByTrain(String trainNumber){
        Session session = sessions.openSession();
        List<PassengerPO> passengers = null;

        try {
            Query query = session.createQuery("select passengers"
                    + "  from TrainPO tr"
                    + " where tr.number = :train_number")
                    .setString("train_number", trainNumber);

            passengers =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return passengers;
    }
}