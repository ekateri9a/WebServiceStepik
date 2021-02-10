package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet dataSet = (UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        long id = 0;
        if(dataSet != null)
            id = dataSet.getId();
        //System.out.println(id);
        return id;
    }

    public long getUserIdByNameAndPassword(String name, String password) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet dataSet = (UsersDataSet) criteria.add(Restrictions.eq("name", name)).add(Restrictions.eq("password", password)).uniqueResult();
        long id = 0;
        if(dataSet != null)
            id = dataSet.getId();
        //System.out.println(id);
        return id;
    }

    public long insertUser(String name, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name, password));
    }
}
