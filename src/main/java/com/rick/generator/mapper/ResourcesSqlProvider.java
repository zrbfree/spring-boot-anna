package com.rick.generator.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.rick.generator.entity.Resources;
import com.rick.generator.entity.ResourcesExample.Criteria;
import com.rick.generator.entity.ResourcesExample.Criterion;
import com.rick.generator.entity.ResourcesExample;
import java.util.List;
import java.util.Map;

public class ResourcesSqlProvider {

    public String countByExample(ResourcesExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_resources");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ResourcesExample example) {
        BEGIN();
        DELETE_FROM("t_resources");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Resources record) {
        BEGIN();
        INSERT_INTO("t_resources");
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getResUrl() != null) {
            VALUES("res_url", "#{resUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(ResourcesExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("res_url");
        SELECT("type");
        SELECT("parent_id");
        SELECT("sort");
        FROM("t_resources");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Resources record = (Resources) parameter.get("record");
        ResourcesExample example = (ResourcesExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_resources");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getResUrl() != null) {
            SET("res_url = #{record.resUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_resources");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("res_url = #{record.resUrl,jdbcType=VARCHAR}");
        SET("type = #{record.type,jdbcType=INTEGER}");
        SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        SET("sort = #{record.sort,jdbcType=INTEGER}");
        
        ResourcesExample example = (ResourcesExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Resources record) {
        BEGIN();
        UPDATE("t_resources");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getResUrl() != null) {
            SET("res_url = #{resUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(ResourcesExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}