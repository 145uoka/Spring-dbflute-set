package com.glue_si.study.basicproject.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.glue_si.study.basicproject.dbflute.allcommon.*;
import com.glue_si.study.basicproject.dbflute.exentity.*;

/**
 * The DB meta of system_property_m. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class SystemPropertyMDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final SystemPropertyMDbm _instance = new SystemPropertyMDbm();
    private SystemPropertyMDbm() {}
    public static SystemPropertyMDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((SystemPropertyM)et).getPropKey(), (et, vl) -> ((SystemPropertyM)et).setPropKey((String)vl), "propKey");
        setupEpg(_epgMap, et -> ((SystemPropertyM)et).getPropValue(), (et, vl) -> ((SystemPropertyM)et).setPropValue((String)vl), "propValue");
        setupEpg(_epgMap, et -> ((SystemPropertyM)et).getDescription(), (et, vl) -> ((SystemPropertyM)et).setDescription((String)vl), "description");
        setupEpg(_epgMap, et -> ((SystemPropertyM)et).getRegisterDatetime(), (et, vl) -> ((SystemPropertyM)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((SystemPropertyM)et).getRegisterUser(), (et, vl) -> ((SystemPropertyM)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((SystemPropertyM)et).getUpdateDatetime(), (et, vl) -> ((SystemPropertyM)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((SystemPropertyM)et).getUpdateUser(), (et, vl) -> ((SystemPropertyM)et).setUpdateUser((String)vl), "updateUser");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "system_property_m";
    protected final String _tableDispName = "system_property_m";
    protected final String _tablePropertyName = "systemPropertyM";
    protected final TableSqlName _tableSqlName = new TableSqlName("system_property_m", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnPropKey = cci("prop_key", "prop_key", null, null, String.class, "propKey", null, true, false, true, "text", 2147483647, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnPropValue = cci("prop_value", "prop_value", null, null, String.class, "propValue", null, false, false, false, "text", 2147483647, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDescription = cci("description", "description", null, null, String.class, "description", null, false, false, false, "text", 2147483647, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("register_datetime", "register_datetime", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, false, "timestamp", 29, 6, "now()", true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterUser = cci("register_user", "register_user", null, null, String.class, "registerUser", null, false, false, false, "text", 2147483647, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("update_datetime", "update_datetime", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, false, "timestamp", 29, 6, "now()", true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateUser = cci("update_user", "update_user", null, null, String.class, "updateUser", null, false, false, false, "text", 2147483647, 0, null, true, null, null, null, null, null, false);

    /**
     * prop_key: {PK, NotNull, text(2147483647)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPropKey() { return _columnPropKey; }
    /**
     * prop_value: {text(2147483647)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPropValue() { return _columnPropValue; }
    /**
     * description: {text(2147483647)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDescription() { return _columnDescription; }
    /**
     * register_datetime: {timestamp(29, 6), default=[now()]}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    /**
     * register_user: {text(2147483647)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    /**
     * update_datetime: {timestamp(29, 6), default=[now()]}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    /**
     * update_user: {text(2147483647)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnPropKey());
        ls.add(columnPropValue());
        ls.add(columnDescription());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterUser());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateUser());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnPropKey()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasCommonColumn() { return true; }
    public List<ColumnInfo> getCommonColumnInfoList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeInsertList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeUpdateList()
    { return newArrayList(columnUpdateDatetime(), columnUpdateUser()); }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.glue_si.study.basicproject.dbflute.exentity.SystemPropertyM"; }
    public String getConditionBeanTypeName() { return "com.glue_si.study.basicproject.dbflute.cbean.SystemPropertyMCB"; }
    public String getBehaviorTypeName() { return "com.glue_si.study.basicproject.dbflute.exbhv.SystemPropertyMBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<SystemPropertyM> getEntityType() { return SystemPropertyM.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public SystemPropertyM newEntity() { return new SystemPropertyM(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((SystemPropertyM)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((SystemPropertyM)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
