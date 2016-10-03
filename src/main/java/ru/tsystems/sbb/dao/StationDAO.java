package ru.tsystems.sbb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;

public class StationDAO extends AbstractDAO<StationPO> {
    public StationPO getStationByName (String stationName) {
        Session session = sessions.openSession();
        StationPO station = null;

        try {
            Query query = session.createQuery("select st"
                    + "  from StationPO st"
                    + " where st.name = :station_name")
                    .setString("station_name", stationName);

            station = (StationPO) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return station;
    }
}
