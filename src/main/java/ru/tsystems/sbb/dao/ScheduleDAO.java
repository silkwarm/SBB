package ru.tsystems.sbb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.sbb.persistence.SchedulePO;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.util.Date;

public class ScheduleDAO extends AbstractDAO<SchedulePO> {
    public Date getTimeByStationAndTrain(StationPO station, TrainPO train) {
        Session session = sessions.openSession();
        SchedulePO schedule = null;

        try {
            Query query = session.createQuery("select s"
                    + "  from T_SCHEDULE s"
                    + " where s.id_train = :id_train and s.id_station = :id_station")
                    .setLong("id_train", station.getId())
                    .setLong("id_station", train.getId());

            schedule = (SchedulePO) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return schedule.getTime();
    }
}
