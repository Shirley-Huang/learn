package com.dandan.model.typeHandler;

import com.dandan.model.enums.SexType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dandan On 八月 26 2019
 * 自定义类型处理器
 */
public class SexEnumTypeHandler implements TypeHandler<SexType> {

    @Override
    public void setParameter(PreparedStatement ps, int i, SexType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.getCode());
    }

    @Override
    public SexType getResult(ResultSet rs, String columnName) throws SQLException {
        return SexType.getSexByCode(rs.getString(columnName));
    }

    @Override
    public SexType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return SexType.getSexByCode(rs.getString(columnIndex));
    }

    @Override
    public SexType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return SexType.getSexByCode(cs.getString(columnIndex));
    }

}
