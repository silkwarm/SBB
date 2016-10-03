package ru.tsystems.sbb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.UserPO;

public class UserDAO extends AbstractDAO<UserPO> {
    public int getUserTypeByLogin(String login){
        Session session = sessions.openSession();
        String userType = "0";
        UserPO user = null;

        try {
            Query query = session.createQuery("select u"
                    + "  from UserPO u"
                    + " where u.login = :login")
                    .setString("login", login);

            user = (UserPO) query.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user.getIs_admin();
    }


}
