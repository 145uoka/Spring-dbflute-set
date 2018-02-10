package com.glue_si.study.basicproject.app.service;

import org.apache.commons.lang3.StringUtils;
import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.optional.OptionalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glue_si.study.basicproject.app.Exception.RecordNotFoundException;
import com.glue_si.study.basicproject.dbflute.exbhv.SystemPropertyMBhv;
import com.glue_si.study.basicproject.dbflute.exentity.SystemPropertyM;

/**
 * システムプロパティ関連のサービスクラス。
 *
 * @author ishigouoka_k
 * $Id:$
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemPropertyService extends AbstractService {

    /** システムプロパティ_M Bhv */
    @Autowired
    SystemPropertyMBhv systemPropertyMBhv;

    /**
     * SystemPropertyMのリストから、指定したkeyのレコードを検索し返却。
     *
     * @param systemPropertyMList 検索対象のSystemPropertyMのリスト
     * @param key 検索key
     * @return 指定したkeyのレコード
     */
    public SystemPropertyM getSystemPropertyMByKey(ListResultBean<SystemPropertyM> systemPropertyMList, String key) {
        for (SystemPropertyM systemPropertyM : systemPropertyMList) {
            if (StringUtils.equals(systemPropertyM.getPropKey(), key)) {
                return systemPropertyM;
            }
        }
        return null;
    }

    /**
     * SystemPropertyMのリストから、指定したkeyの前方一致検索によるレコードを検索し返却。
     *
     * @param systemPropertyMList 検索対象のSystemPropertyMのリスト
     * @param key 検索対象のprefixkey
     * @return 指定したkeyの前方一致検索によるレコード
     */
    public ListResultBean<SystemPropertyM> getLikeSearchPrefixByPropKey(String prefix) {
        ListResultBean<SystemPropertyM> systemPropertyMList = systemPropertyMBhv.selectList(cb -> {
            cb.query().setPropKey_LikeSearch(prefix,  op -> op.likePrefix());
            cb.query().addOrderBy_PropKey_Asc();
        });

        return systemPropertyMList;
    }
    /**
     * プロパティ取得
     *
     * @param propKey
     * @return
     * @throws RecordNotFoundException
     */
    public String getSystemPropertyValue(String propKey) throws RecordNotFoundException {
        String result = null;

        OptionalEntity<SystemPropertyM> systemPropertyMList = systemPropertyMBhv.selectByPK(propKey);
        if(!systemPropertyMList.isPresent()){
            throw new RecordNotFoundException("SystemPropertyM",propKey);
        }

        result = systemPropertyMList.get().getPropValue();

        return result;
    }

}
