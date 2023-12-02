package com.benjamin.handler;

import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.benjamin.singleton.AesInstance;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class AesTypeHandler extends BaseTypeHandler<Object> {

    private SymmetricCrypto aes = AesInstance.getInstance();



    /**
     * 非空字段加密
     *
     * @param preparedStatement
     * @param i
     * @param o
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        try {
            if (StringUtils.isBlank((String) o)) {
                return;
            }
            // todo 加密操作
            String encrypt = aes.encryptHex((String) o);
            preparedStatement.setString(i, encrypt);
        } catch (Exception e) {
            log.error("typeHandler加密异常：" + e);
        }
    }

    /**
     * 非空字段解密
     *
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String col = resultSet.getString(s);
        try {
            if (StringUtils.isBlank(col)) {
                return col;
            }
            // todo 对结果col进行解密操作
            col = aes.decryptStr(col);
        } catch (Exception e) {
            log.error("typeHandler解密异常：" + e);
        }
        return col;
    }

    /**
     * 可空字段加密
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String col = resultSet.getString(i);
        try {
            if (StringUtils.isBlank(col)) {
                return col;
            }
            // todo 对结果col进行解密操作
            col = aes.decryptStr(col);
        } catch (Exception e) {
            log.error("typeHandler解密异常：" + e);
        }
        return col;
    }

    /**
     * 可空字段解密
     *
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String col = callableStatement.getString(i);
        try {
            if (StringUtils.isBlank(col)) {
                return col;
            }
            // todo 对结果col进行解密操作
            col = aes.decryptStr(col);
        } catch (Exception e) {
            log.error("typeHandler解密异常：" + e);
        }
        return col;
    }
}
