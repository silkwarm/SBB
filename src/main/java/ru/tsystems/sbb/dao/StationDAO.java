package ru.tsystems.sbb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.util.List;

public class StationDAO extends AbstractDAO<StationPO> {
    public StationPO getStationByName (String stationName) {
        Session session = sessions.openSession();
        StationPO station = null;

        try {
            Query query = session.createQuery("select st"
                    + "  from StationPO st"
                    + " where st.name = :station_name")
                    .setString("station_name", stationName);

            station = (StationPO) query.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return station;
    }

    public List<TrainPO> getTrainsByStation(String stationName) {
        Session session = sessions.openSession();
        List<TrainPO> trains = null;

        try {
            Query query = session.createQuery("select st.trains"
                    + "  from StationPO st"
                    + " where st.name = :station_name")
                    .setString("station_name", stationName);

            trains = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return trains;

    }
}
