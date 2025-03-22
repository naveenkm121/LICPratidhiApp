package com.licapps.bmmis.data.localdb;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.licapps.bmmis.data.model.prospectives.Prospective;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PlanDao_Impl implements PlanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Prospective> __insertionAdapterOfProspective;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllProspectives;

  public PlanDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProspective = new EntityInsertionAdapter<Prospective>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `prospectives` (`agencyName`,`agencyCode`,`qualMDRT`,`prospMDRT`,`nop`,`fp`,`srno`,`commission`,`qualCentury`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Prospective entity) {
        if (entity.getAgencyName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getAgencyName());
        }
        if (entity.getAgencyCode() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAgencyCode());
        }
        if (entity.getQualMDRT() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getQualMDRT());
        }
        if (entity.getProspMDRT() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getProspMDRT());
        }
        if (entity.getNop() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getNop());
        }
        if (entity.getFp() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getFp());
        }
        statement.bindLong(7, entity.getSrno());
        if (entity.getCommission() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCommission());
        }
        if (entity.getQualCentury() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getQualCentury());
        }
      }
    };
    this.__preparedStmtOfDeleteAllProspectives = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM prospectives";
        return _query;
      }
    };
  }

  @Override
  public Object insertAllProspectives(final List<Prospective> prospectives,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProspective.insert(prospectives);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllProspectives(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllProspectives.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllProspectives.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Prospective>> getProspectivesList() {
    final String _sql = "SELECT * FROM prospectives";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"prospectives"}, false, new Callable<List<Prospective>>() {
      @Override
      @Nullable
      public List<Prospective> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAgencyName = CursorUtil.getColumnIndexOrThrow(_cursor, "agencyName");
          final int _cursorIndexOfAgencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "agencyCode");
          final int _cursorIndexOfQualMDRT = CursorUtil.getColumnIndexOrThrow(_cursor, "qualMDRT");
          final int _cursorIndexOfProspMDRT = CursorUtil.getColumnIndexOrThrow(_cursor, "prospMDRT");
          final int _cursorIndexOfNop = CursorUtil.getColumnIndexOrThrow(_cursor, "nop");
          final int _cursorIndexOfFp = CursorUtil.getColumnIndexOrThrow(_cursor, "fp");
          final int _cursorIndexOfSrno = CursorUtil.getColumnIndexOrThrow(_cursor, "srno");
          final int _cursorIndexOfCommission = CursorUtil.getColumnIndexOrThrow(_cursor, "commission");
          final int _cursorIndexOfQualCentury = CursorUtil.getColumnIndexOrThrow(_cursor, "qualCentury");
          final List<Prospective> _result = new ArrayList<Prospective>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Prospective _item;
            final String _tmpAgencyName;
            if (_cursor.isNull(_cursorIndexOfAgencyName)) {
              _tmpAgencyName = null;
            } else {
              _tmpAgencyName = _cursor.getString(_cursorIndexOfAgencyName);
            }
            final String _tmpAgencyCode;
            if (_cursor.isNull(_cursorIndexOfAgencyCode)) {
              _tmpAgencyCode = null;
            } else {
              _tmpAgencyCode = _cursor.getString(_cursorIndexOfAgencyCode);
            }
            final String _tmpQualMDRT;
            if (_cursor.isNull(_cursorIndexOfQualMDRT)) {
              _tmpQualMDRT = null;
            } else {
              _tmpQualMDRT = _cursor.getString(_cursorIndexOfQualMDRT);
            }
            final String _tmpProspMDRT;
            if (_cursor.isNull(_cursorIndexOfProspMDRT)) {
              _tmpProspMDRT = null;
            } else {
              _tmpProspMDRT = _cursor.getString(_cursorIndexOfProspMDRT);
            }
            final String _tmpNop;
            if (_cursor.isNull(_cursorIndexOfNop)) {
              _tmpNop = null;
            } else {
              _tmpNop = _cursor.getString(_cursorIndexOfNop);
            }
            final String _tmpFp;
            if (_cursor.isNull(_cursorIndexOfFp)) {
              _tmpFp = null;
            } else {
              _tmpFp = _cursor.getString(_cursorIndexOfFp);
            }
            final int _tmpSrno;
            _tmpSrno = _cursor.getInt(_cursorIndexOfSrno);
            final String _tmpCommission;
            if (_cursor.isNull(_cursorIndexOfCommission)) {
              _tmpCommission = null;
            } else {
              _tmpCommission = _cursor.getString(_cursorIndexOfCommission);
            }
            final String _tmpQualCentury;
            if (_cursor.isNull(_cursorIndexOfQualCentury)) {
              _tmpQualCentury = null;
            } else {
              _tmpQualCentury = _cursor.getString(_cursorIndexOfQualCentury);
            }
            _item = new Prospective(_tmpAgencyName,_tmpAgencyCode,_tmpQualMDRT,_tmpProspMDRT,_tmpNop,_tmpFp,_tmpSrno,_tmpCommission,_tmpQualCentury);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
