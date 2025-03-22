package com.licapps.bmmis.data.localdb;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile PlanDao _planDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `prospectives` (`agencyName` TEXT NOT NULL, `agencyCode` TEXT NOT NULL, `qualMDRT` TEXT NOT NULL, `prospMDRT` TEXT NOT NULL, `nop` TEXT NOT NULL, `fp` TEXT NOT NULL, `srno` INTEGER NOT NULL, `commission` TEXT NOT NULL, `qualCentury` TEXT NOT NULL, PRIMARY KEY(`agencyCode`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fd29b13f6b227672bdc3c92ba8f3faf2')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `prospectives`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsProspectives = new HashMap<String, TableInfo.Column>(9);
        _columnsProspectives.put("agencyName", new TableInfo.Column("agencyName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("agencyCode", new TableInfo.Column("agencyCode", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("qualMDRT", new TableInfo.Column("qualMDRT", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("prospMDRT", new TableInfo.Column("prospMDRT", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("nop", new TableInfo.Column("nop", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("fp", new TableInfo.Column("fp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("srno", new TableInfo.Column("srno", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("commission", new TableInfo.Column("commission", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProspectives.put("qualCentury", new TableInfo.Column("qualCentury", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProspectives = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProspectives = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProspectives = new TableInfo("prospectives", _columnsProspectives, _foreignKeysProspectives, _indicesProspectives);
        final TableInfo _existingProspectives = TableInfo.read(db, "prospectives");
        if (!_infoProspectives.equals(_existingProspectives)) {
          return new RoomOpenHelper.ValidationResult(false, "prospectives(com.licapps.bmmis.data.model.prospectives.Prospective).\n"
                  + " Expected:\n" + _infoProspectives + "\n"
                  + " Found:\n" + _existingProspectives);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fd29b13f6b227672bdc3c92ba8f3faf2", "7481fd126ba7af339ed055184599cad5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "prospectives");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `prospectives`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PlanDao.class, PlanDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PlanDao planDao() {
    if (_planDao != null) {
      return _planDao;
    } else {
      synchronized(this) {
        if(_planDao == null) {
          _planDao = new PlanDao_Impl(this);
        }
        return _planDao;
      }
    }
  }
}
