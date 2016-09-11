package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import persistence.PassengerPO;
import persistence.TrainPO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PassengerDAO extends AbstractDAO<PassengerPO> {
    public Set<PassengerPO> getPassangersByTrain(TrainPO train) throws SQLException {
        Session session = sessions.openSession();
        Set<PassengerPO> passengers = new HashSet<PassengerPO>();

        try {
            Query query = session.createQuery("select p"
                                            + "  from T_PASSENGER p"
                                            + "     , T_TRAIN     tr"
                                            + "     , T_TICKET    tk"
                                            + " where tk.id_train = tr.id"
                                            + "   and tk.id_passenger = p.id"
                                            + "   and tr.id = :train_id")
                    .setLong("train_id", train.getId());

            passengers = (Set<PassengerPO>) query.list();
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
