package service;

import dao.ProjectDao;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDao {
    @Override
    public void add(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(project);
        closeTransactionSession();
    }

    @Override
    public List<Project> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT*FROM EMPLOYEE";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project>projectsList = query.list();
        closeTransactionSession();
        return projectsList;
    }

    @Override
    public Project getById(Long id) throws SQLException {
        openTransactionSession();
        String sql = "SELECT*FROM EMPLOYEE WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id",id);
        Project project = (Project) query.getSingleResult();
        closeTransactionSession();
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {

        openTransactionSession();
        Session session = getSession();
        session.update(project);
        closeTransactionSession();
    }

    @Override
    public void remove(Project project) throws SQLException {

        openTransactionSession();
        Session session = getSession();
        session.delete(project);
        closeTransactionSession();
    }
}
