package com.common.base.dao;

import com.common.base.model.Sqllog;
import com.common.constant.SqlConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @program: BankInter
 * @description: 持久层基类
 * @author: chengy
 * @create: 2018-07-09 16:37
 **/
@Repository("baseDao")
@Scope("prototype")
public class BaseDao {
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(BaseDao.class);


    /**
     * 执行sql返回查询出的一个字段并转换为String
     *
     * @param sql 执行的sql
     * @return String
     * @throws DataAccessException
     */
    public String queryForString(String sql) throws DataAccessException {
        String backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.queryForObject(sql, String.class);
            status = SqlConstants.successful;
        } catch (EmptyResultDataAccessException emptyException) {
            throw emptyException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, null);
        }
        return backVal;
    }

    /**
     * 执行预编译sql返回查询出的一个字段并转换为String
     *
     * @param sql  执行的预编译sql
     * @param args 参数数组
     * @return String
     * @throws DataAccessException
     */
    public String queryForString(String sql, Object[] args) throws DataAccessException {
        String backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.queryForObject(sql, args, String.class);
            status = SqlConstants.successful;
        } catch (EmptyResultDataAccessException emptyException) {
            throw emptyException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, args);
        }
        return backVal;
    }

    /**
     * 执行sql返回查询出的一条数据并转换为Map
     *
     * @param sql 执行的sql
     * @return Map
     * @throws DataAccessException
     */
    @SuppressWarnings("rawtypes")
    public Map queryForMap(String sql) throws DataAccessException {
        List<Map<String, Object>> backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql,
                    new RowMapperResultSetExtractor<Map<String, Object>>(new ColumnMapRowMapper(), 1));
            status = SqlConstants.successful;
        } catch (EmptyResultDataAccessException emptyException) {
            throw emptyException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, null);
        }
        return DataAccessUtils.uniqueResult(backVal);
    }

    /**
     * 执行预编译sql返回查询出的一条数据并转换为Map
     *
     * @param sql  执行的预编译sql
     * @param args 参数数组
     * @return Map
     * @throws DataAccessException
     */
    public Map queryForMap(String sql, Object[] args) throws DataAccessException {
        List<Map<String, Object>> backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql, args,
                    new RowMapperResultSetExtractor<Map<String, Object>>(new ColumnMapRowMapper(), 1));
            status = SqlConstants.successful;
        } catch (EmptyResultDataAccessException emptyException) {
            throw emptyException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, args);
        }
        return DataAccessUtils.uniqueResult(backVal);
    }

    /**
     * 执行sql返回查询出的数据并转换为List
     *
     * @param sql 执行的sql
     * @return List
     * @throws DataAccessException
     */
    @SuppressWarnings("rawtypes")
    public List queryForList(String sql) throws DataAccessException {
        List<Map<String, Object>> backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql, new RowMapperResultSetExtractor<Map<String, Object>>(new ColumnMapRowMapper(), 0));
            status = SqlConstants.successful;
        } catch (DataAccessException dataAccessException) {
            throw dataAccessException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, null);
        }
        return backVal;
    }

    /**
     * 执行预编译sql返回查询出的数据并转换为List
     *
     * @param sql  执行的预编译sql
     * @param args 参数数组
     * @return List
     * @throws DataAccessException
     */
    @SuppressWarnings("rawtypes")
    public List queryForList(String sql, Object[] args) throws DataAccessException {
        List<Map<String, Object>> backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql, args, new RowMapperResultSetExtractor<Map<String, Object>>(new ColumnMapRowMapper(), 0));
            status = SqlConstants.successful;
        } catch (DataAccessException dataAccessException) {
            throw dataAccessException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, args);
        }
        return backVal;
    }

    /**
     * 执行sql更新（插入）数据，并返回更新（插入）成功的条数
     *
     * @param sql 执行的sql
     * @return int
     * @throws DataAccessException
     */
    public int updateOrInsert(String sql) throws DataAccessException {
        int backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.update(sql);
            status = SqlConstants.successful;
        } catch (DataAccessException dataAccessException) {
            throw dataAccessException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, null);
        }
        return backVal;
    }

    /**
     * 执行预编译sql更新（插入）数据，并返回更新（插入）成功的条数
     *
     * @param sql  执行的预编译sql
     * @param args 参数数组
     * @return int
     * @throws DataAccessException
     */
    public int updateOrInsert(String sql, Object[] args) throws DataAccessException {
        int backVal;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.update(sql, args);
            status = SqlConstants.successful;
        } catch (DataAccessException dataAccessException) {
            throw dataAccessException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, args);
        }
        return backVal;
    }

    /**
     * 查询 model
     *
     * @param sql  预编译带？的sql
     * @param args 参数数组
     * @return model
     */
    @SuppressWarnings("rawtypes")
    public <T> T queryForModel(String sql, Object[] args, Class<T> cls) throws DataAccessException {
        List<T> backVal = null;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(cls));
            status = SqlConstants.successful;
        } catch (DataAccessException e) {
            throw e;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, args);
        }
        return DataAccessUtils.uniqueResult(backVal);
    }

    /**
     * 查询 model
     *
     * @param sql
     * @return model
     */
    @SuppressWarnings("rawtypes")
    public <T> T queryForModel(String sql, Class<T> cls) throws DataAccessException {
        List<T> backVal = null;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(cls));
            status = SqlConstants.successful;
        } catch (DataAccessException e) {
            throw e;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, null);
        }
        return DataAccessUtils.uniqueResult(backVal);
    }

    /**
     * 查询 model List
     *
     * @param sql  预编译带？的sql
     * @param args 参数数组
     * @return List
     */
    @SuppressWarnings("rawtypes")
    public List queryForModelList(String sql, Object[] args, Class cls) throws DataAccessException {
        List<Class> backVal = null;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql, args, new BeanPropertyRowMapper(cls));
            status = SqlConstants.successful;
        } catch (DataAccessException e) {
            throw e;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, args);
        }
        return backVal;
    }

    /**
     * 查询 model List
     *
     * @param sql
     * @return List
     */
    @SuppressWarnings("rawtypes")
    public List queryForModelList(String sql, Class cls) throws DataAccessException {
        List<Class> backVal = null;
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        try {
            backVal = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(cls));
            status = SqlConstants.successful;
        } catch (DataAccessException e) {
            throw e;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, null);
        }
        return backVal;
    }

    /**
     * 执行预编译sql存储过程
     *
     * @param sql  执行的预编译sql
     * @param args 参数数组
     * @return String
     * @throws DataAccessException
     */
    public String executeCallable(String sql, Object[] args) throws DataAccessException {
        String backVal = "";
        Long stime = System.currentTimeMillis();
        String status = SqlConstants.faild;
        logger.info("调用程序包开始-------------->");
        try {
            backVal = (String) this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        public CallableStatement createCallableStatement(Connection con) throws SQLException {
                            String storedProc = sql;// 调用的sql
                            CallableStatement cs = con.prepareCall(storedProc);
                            if (null != args) {
                                for (int i = 0; i <= args.length - 1; i++) {
                                    if (i == 0) {
                                        cs.registerOutParameter(i + 1, (Integer) args[i]);// 注册输出参数的类型
                                        continue;
                                    }
                                    if (args[i] instanceof String) {
                                        cs.setString(i + 1, String.valueOf(args[i]));// 设置输入参数的值
                                    } else {
                                        cs.setDouble(i + 1, (Double) args[i]);// 设置输入参数的值
                                    }
                                }
                            }
                            return cs;
                        }
                    }, new CallableStatementCallback() {
                        public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                            cs.execute();
                            ResultSet rs = (ResultSet) cs.getObject(1);
                            StringBuffer s = new StringBuffer();
                            while (rs.next()) {
                                s.append(rs.getString(1));
                            }
                            return s.toString();// 获取输出参数的值
                        }
                    });
            status = SqlConstants.successful;
        } catch (DataAccessException dataAccessException) {
            status = SqlConstants.faild;
            throw dataAccessException;
        } finally {
            Long etime = System.currentTimeMillis();
            log(sql, stime, etime, status, args);
            logger.info("<---------------调用程序包结束");
        }
        return backVal;
    }

    /**
     * 记录sql日志
     *
     * @param sql       执行的sql
     * @param starttime 开始时间
     * @param endtime   结束时间
     * @param status    是否成功
     * @param args      预编译sql参数
     */
    private void log(String sql, Long starttime, Long endtime, String status, Object[] args) {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        String callLocation = stack[2].getClassName();
        int lineNum = stack[2].getLineNumber();
        Long timeConsuming = endtime - starttime;
        Sqllog sqlLog = new Sqllog(sql, timeConsuming, status, callLocation, lineNum, args);
        logger.info(sqlLog.toString());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
