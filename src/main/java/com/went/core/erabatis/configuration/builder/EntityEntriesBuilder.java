package com.went.core.erabatis.configuration.builder;

import com.went.core.erabatis.app.EraBatis;
import com.went.core.erabatis.configuration.EntityEntry;

import java.util.List;
/**
 * <p>Title: EntityEntriesBuilder </p>
 * <p>Description: 实体构建 </p>
 * <p>Copyright: Shanghai era Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public interface EntityEntriesBuilder {

  List<EntityEntry> getEntries(EraBatis eraBatis);
}
