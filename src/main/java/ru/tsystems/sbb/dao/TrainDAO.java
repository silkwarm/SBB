package ru.tsystems.sbb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.util.Date;

public class TrainDAO extends AbstractDAO<TrainPO> {
    public TrainPO getTrainByNumber(String trainNumber) {
        Session session = sessions.openSession();
        TrainPO train = null;

        try {
            Query query = session.createQuery("select tr"
                    + "  from TrainPO tr"
                    + " where tr.number = :train_number")
                    .setString("train_number", trainNumber);

            train = (TrainPO) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return train;
    }
}