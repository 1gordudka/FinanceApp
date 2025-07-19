package com.finance.common.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.finance.common.database.converters.SyncStateConverter;
import com.finance.common.database.entities.SyncState;
import com.finance.common.database.entities.TransactionEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TransactionDao_Impl implements TransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TransactionEntity> __insertionAdapterOfTransactionEntity;

  private final SyncStateConverter __syncStateConverter = new SyncStateConverter();

  private final EntityDeletionOrUpdateAdapter<TransactionEntity> __updateAdapterOfTransactionEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTransactionSyncState;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTransactionWithServerId;

  private final SharedSQLiteStatement __preparedStmtOfMarkTransactionAsDeleted;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTransaction;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMarkedTransactions;

  public TransactionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransactionEntity = new EntityInsertionAdapter<TransactionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `transactions` (`id`,`serverId`,`accountId`,`accountName`,`accountBalance`,`accountCurrency`,`categoryId`,`categoryName`,`categoryEmoji`,`isIncome`,`amount`,`transactionDate`,`comment`,`createdAt`,`updatedAt`,`lastSyncTime`,`syncState`,`isDeleted`,`version`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TransactionEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getServerId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getServerId());
        }
        statement.bindLong(3, entity.getAccountId());
        if (entity.getAccountName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAccountName());
        }
        if (entity.getAccountBalance() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAccountBalance());
        }
        if (entity.getAccountCurrency() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAccountCurrency());
        }
        statement.bindLong(7, entity.getCategoryId());
        if (entity.getCategoryName() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCategoryName());
        }
        if (entity.getCategoryEmoji() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getCategoryEmoji());
        }
        final int _tmp = entity.isIncome() ? 1 : 0;
        statement.bindLong(10, _tmp);
        if (entity.getAmount() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAmount());
        }
        if (entity.getTransactionDate() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getTransactionDate());
        }
        if (entity.getComment() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getComment());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getUpdatedAt());
        }
        if (entity.getLastSyncTime() == null) {
          statement.bindNull(16);
        } else {
          statement.bindLong(16, entity.getLastSyncTime());
        }
        final String _tmp_1 = __syncStateConverter.fromSyncState(entity.getSyncState());
        if (_tmp_1 == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, _tmp_1);
        }
        final int _tmp_2 = entity.isDeleted() ? 1 : 0;
        statement.bindLong(18, _tmp_2);
        statement.bindLong(19, entity.getVersion());
      }
    };
    this.__updateAdapterOfTransactionEntity = new EntityDeletionOrUpdateAdapter<TransactionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `transactions` SET `id` = ?,`serverId` = ?,`accountId` = ?,`accountName` = ?,`accountBalance` = ?,`accountCurrency` = ?,`categoryId` = ?,`categoryName` = ?,`categoryEmoji` = ?,`isIncome` = ?,`amount` = ?,`transactionDate` = ?,`comment` = ?,`createdAt` = ?,`updatedAt` = ?,`lastSyncTime` = ?,`syncState` = ?,`isDeleted` = ?,`version` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TransactionEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getServerId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getServerId());
        }
        statement.bindLong(3, entity.getAccountId());
        if (entity.getAccountName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAccountName());
        }
        if (entity.getAccountBalance() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAccountBalance());
        }
        if (entity.getAccountCurrency() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAccountCurrency());
        }
        statement.bindLong(7, entity.getCategoryId());
        if (entity.getCategoryName() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCategoryName());
        }
        if (entity.getCategoryEmoji() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getCategoryEmoji());
        }
        final int _tmp = entity.isIncome() ? 1 : 0;
        statement.bindLong(10, _tmp);
        if (entity.getAmount() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAmount());
        }
        if (entity.getTransactionDate() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getTransactionDate());
        }
        if (entity.getComment() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getComment());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getUpdatedAt());
        }
        if (entity.getLastSyncTime() == null) {
          statement.bindNull(16);
        } else {
          statement.bindLong(16, entity.getLastSyncTime());
        }
        final String _tmp_1 = __syncStateConverter.fromSyncState(entity.getSyncState());
        if (_tmp_1 == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, _tmp_1);
        }
        final int _tmp_2 = entity.isDeleted() ? 1 : 0;
        statement.bindLong(18, _tmp_2);
        statement.bindLong(19, entity.getVersion());
        statement.bindLong(20, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateTransactionSyncState = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE transactions SET syncState = ?, lastSyncTime = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTransactionWithServerId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE transactions SET serverId = ?, syncState = ?, lastSyncTime = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkTransactionAsDeleted = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE transactions SET isDeleted = 1, syncState = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTransaction = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM transactions WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteMarkedTransactions = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM transactions WHERE isDeleted = 1 AND syncState = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertTransaction(final TransactionEntity transaction,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTransactionEntity.insertAndReturnId(transaction);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertTransactions(final List<TransactionEntity> transactions,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTransactionEntity.insert(transactions);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTransaction(final TransactionEntity transaction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTransactionEntity.handle(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTransactionSyncState(final int id, final SyncState syncState,
      final long lastSyncTime, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTransactionSyncState.acquire();
        int _argIndex = 1;
        final String _tmp = __syncStateConverter.fromSyncState(syncState);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, lastSyncTime);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfUpdateTransactionSyncState.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTransactionWithServerId(final int localId, final int serverId,
      final SyncState syncState, final long lastSyncTime,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTransactionWithServerId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, serverId);
        _argIndex = 2;
        final String _tmp = __syncStateConverter.fromSyncState(syncState);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 3;
        _stmt.bindLong(_argIndex, lastSyncTime);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, localId);
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
          __preparedStmtOfUpdateTransactionWithServerId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object markTransactionAsDeleted(final int id, final SyncState syncState,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkTransactionAsDeleted.acquire();
        int _argIndex = 1;
        final String _tmp = __syncStateConverter.fromSyncState(syncState);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfMarkTransactionAsDeleted.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTransaction(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTransaction.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfDeleteTransaction.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMarkedTransactions(final SyncState syncState,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMarkedTransactions.acquire();
        int _argIndex = 1;
        final String _tmp = __syncStateConverter.fromSyncState(syncState);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
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
          __preparedStmtOfDeleteMarkedTransactions.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<TransactionEntity>> getAllTransactions() {
    final String _sql = "SELECT * FROM transactions WHERE isDeleted = 0 ORDER BY transactionDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"transactions"}, new Callable<List<TransactionEntity>>() {
      @Override
      @NonNull
      public List<TransactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfAccountName = CursorUtil.getColumnIndexOrThrow(_cursor, "accountName");
          final int _cursorIndexOfAccountBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "accountBalance");
          final int _cursorIndexOfAccountCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "accountCurrency");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
          final int _cursorIndexOfCategoryEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryEmoji");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
          final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getInt(_cursorIndexOfServerId);
            }
            final int _tmpAccountId;
            _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            final String _tmpAccountName;
            if (_cursor.isNull(_cursorIndexOfAccountName)) {
              _tmpAccountName = null;
            } else {
              _tmpAccountName = _cursor.getString(_cursorIndexOfAccountName);
            }
            final String _tmpAccountBalance;
            if (_cursor.isNull(_cursorIndexOfAccountBalance)) {
              _tmpAccountBalance = null;
            } else {
              _tmpAccountBalance = _cursor.getString(_cursorIndexOfAccountBalance);
            }
            final String _tmpAccountCurrency;
            if (_cursor.isNull(_cursorIndexOfAccountCurrency)) {
              _tmpAccountCurrency = null;
            } else {
              _tmpAccountCurrency = _cursor.getString(_cursorIndexOfAccountCurrency);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpCategoryName;
            if (_cursor.isNull(_cursorIndexOfCategoryName)) {
              _tmpCategoryName = null;
            } else {
              _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            }
            final String _tmpCategoryEmoji;
            if (_cursor.isNull(_cursorIndexOfCategoryEmoji)) {
              _tmpCategoryEmoji = null;
            } else {
              _tmpCategoryEmoji = _cursor.getString(_cursorIndexOfCategoryEmoji);
            }
            final boolean _tmpIsIncome;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp != 0;
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpTransactionDate;
            if (_cursor.isNull(_cursorIndexOfTransactionDate)) {
              _tmpTransactionDate = null;
            } else {
              _tmpTransactionDate = _cursor.getString(_cursorIndexOfTransactionDate);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            }
            final SyncState _tmpSyncState;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __syncStateConverter.toSyncState(_tmp_1);
            final boolean _tmpIsDeleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_2 != 0;
            final int _tmpVersion;
            _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
            _item = new TransactionEntity(_tmpId,_tmpServerId,_tmpAccountId,_tmpAccountName,_tmpAccountBalance,_tmpAccountCurrency,_tmpCategoryId,_tmpCategoryName,_tmpCategoryEmoji,_tmpIsIncome,_tmpAmount,_tmpTransactionDate,_tmpComment,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastSyncTime,_tmpSyncState,_tmpIsDeleted,_tmpVersion);
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

  @Override
  public Flow<List<TransactionEntity>> getIncomeTransactions() {
    final String _sql = "SELECT * FROM transactions WHERE isIncome = 1 AND isDeleted = 0 ORDER BY transactionDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"transactions"}, new Callable<List<TransactionEntity>>() {
      @Override
      @NonNull
      public List<TransactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfAccountName = CursorUtil.getColumnIndexOrThrow(_cursor, "accountName");
          final int _cursorIndexOfAccountBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "accountBalance");
          final int _cursorIndexOfAccountCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "accountCurrency");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
          final int _cursorIndexOfCategoryEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryEmoji");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
          final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getInt(_cursorIndexOfServerId);
            }
            final int _tmpAccountId;
            _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            final String _tmpAccountName;
            if (_cursor.isNull(_cursorIndexOfAccountName)) {
              _tmpAccountName = null;
            } else {
              _tmpAccountName = _cursor.getString(_cursorIndexOfAccountName);
            }
            final String _tmpAccountBalance;
            if (_cursor.isNull(_cursorIndexOfAccountBalance)) {
              _tmpAccountBalance = null;
            } else {
              _tmpAccountBalance = _cursor.getString(_cursorIndexOfAccountBalance);
            }
            final String _tmpAccountCurrency;
            if (_cursor.isNull(_cursorIndexOfAccountCurrency)) {
              _tmpAccountCurrency = null;
            } else {
              _tmpAccountCurrency = _cursor.getString(_cursorIndexOfAccountCurrency);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpCategoryName;
            if (_cursor.isNull(_cursorIndexOfCategoryName)) {
              _tmpCategoryName = null;
            } else {
              _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            }
            final String _tmpCategoryEmoji;
            if (_cursor.isNull(_cursorIndexOfCategoryEmoji)) {
              _tmpCategoryEmoji = null;
            } else {
              _tmpCategoryEmoji = _cursor.getString(_cursorIndexOfCategoryEmoji);
            }
            final boolean _tmpIsIncome;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp != 0;
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpTransactionDate;
            if (_cursor.isNull(_cursorIndexOfTransactionDate)) {
              _tmpTransactionDate = null;
            } else {
              _tmpTransactionDate = _cursor.getString(_cursorIndexOfTransactionDate);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            }
            final SyncState _tmpSyncState;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __syncStateConverter.toSyncState(_tmp_1);
            final boolean _tmpIsDeleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_2 != 0;
            final int _tmpVersion;
            _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
            _item = new TransactionEntity(_tmpId,_tmpServerId,_tmpAccountId,_tmpAccountName,_tmpAccountBalance,_tmpAccountCurrency,_tmpCategoryId,_tmpCategoryName,_tmpCategoryEmoji,_tmpIsIncome,_tmpAmount,_tmpTransactionDate,_tmpComment,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastSyncTime,_tmpSyncState,_tmpIsDeleted,_tmpVersion);
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

  @Override
  public Flow<List<TransactionEntity>> getOutcomeTransactions() {
    final String _sql = "SELECT * FROM transactions WHERE isIncome = 0 AND isDeleted = 0 ORDER BY transactionDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"transactions"}, new Callable<List<TransactionEntity>>() {
      @Override
      @NonNull
      public List<TransactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfAccountName = CursorUtil.getColumnIndexOrThrow(_cursor, "accountName");
          final int _cursorIndexOfAccountBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "accountBalance");
          final int _cursorIndexOfAccountCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "accountCurrency");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
          final int _cursorIndexOfCategoryEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryEmoji");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
          final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getInt(_cursorIndexOfServerId);
            }
            final int _tmpAccountId;
            _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            final String _tmpAccountName;
            if (_cursor.isNull(_cursorIndexOfAccountName)) {
              _tmpAccountName = null;
            } else {
              _tmpAccountName = _cursor.getString(_cursorIndexOfAccountName);
            }
            final String _tmpAccountBalance;
            if (_cursor.isNull(_cursorIndexOfAccountBalance)) {
              _tmpAccountBalance = null;
            } else {
              _tmpAccountBalance = _cursor.getString(_cursorIndexOfAccountBalance);
            }
            final String _tmpAccountCurrency;
            if (_cursor.isNull(_cursorIndexOfAccountCurrency)) {
              _tmpAccountCurrency = null;
            } else {
              _tmpAccountCurrency = _cursor.getString(_cursorIndexOfAccountCurrency);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpCategoryName;
            if (_cursor.isNull(_cursorIndexOfCategoryName)) {
              _tmpCategoryName = null;
            } else {
              _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            }
            final String _tmpCategoryEmoji;
            if (_cursor.isNull(_cursorIndexOfCategoryEmoji)) {
              _tmpCategoryEmoji = null;
            } else {
              _tmpCategoryEmoji = _cursor.getString(_cursorIndexOfCategoryEmoji);
            }
            final boolean _tmpIsIncome;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp != 0;
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpTransactionDate;
            if (_cursor.isNull(_cursorIndexOfTransactionDate)) {
              _tmpTransactionDate = null;
            } else {
              _tmpTransactionDate = _cursor.getString(_cursorIndexOfTransactionDate);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            }
            final SyncState _tmpSyncState;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __syncStateConverter.toSyncState(_tmp_1);
            final boolean _tmpIsDeleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_2 != 0;
            final int _tmpVersion;
            _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
            _item = new TransactionEntity(_tmpId,_tmpServerId,_tmpAccountId,_tmpAccountName,_tmpAccountBalance,_tmpAccountCurrency,_tmpCategoryId,_tmpCategoryName,_tmpCategoryEmoji,_tmpIsIncome,_tmpAmount,_tmpTransactionDate,_tmpComment,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastSyncTime,_tmpSyncState,_tmpIsDeleted,_tmpVersion);
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

  @Override
  public Object getTransactionById(final int id,
      final Continuation<? super TransactionEntity> $completion) {
    final String _sql = "SELECT * FROM transactions WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TransactionEntity>() {
      @Override
      @Nullable
      public TransactionEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfAccountName = CursorUtil.getColumnIndexOrThrow(_cursor, "accountName");
          final int _cursorIndexOfAccountBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "accountBalance");
          final int _cursorIndexOfAccountCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "accountCurrency");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
          final int _cursorIndexOfCategoryEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryEmoji");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
          final TransactionEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getInt(_cursorIndexOfServerId);
            }
            final int _tmpAccountId;
            _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            final String _tmpAccountName;
            if (_cursor.isNull(_cursorIndexOfAccountName)) {
              _tmpAccountName = null;
            } else {
              _tmpAccountName = _cursor.getString(_cursorIndexOfAccountName);
            }
            final String _tmpAccountBalance;
            if (_cursor.isNull(_cursorIndexOfAccountBalance)) {
              _tmpAccountBalance = null;
            } else {
              _tmpAccountBalance = _cursor.getString(_cursorIndexOfAccountBalance);
            }
            final String _tmpAccountCurrency;
            if (_cursor.isNull(_cursorIndexOfAccountCurrency)) {
              _tmpAccountCurrency = null;
            } else {
              _tmpAccountCurrency = _cursor.getString(_cursorIndexOfAccountCurrency);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpCategoryName;
            if (_cursor.isNull(_cursorIndexOfCategoryName)) {
              _tmpCategoryName = null;
            } else {
              _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            }
            final String _tmpCategoryEmoji;
            if (_cursor.isNull(_cursorIndexOfCategoryEmoji)) {
              _tmpCategoryEmoji = null;
            } else {
              _tmpCategoryEmoji = _cursor.getString(_cursorIndexOfCategoryEmoji);
            }
            final boolean _tmpIsIncome;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp != 0;
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpTransactionDate;
            if (_cursor.isNull(_cursorIndexOfTransactionDate)) {
              _tmpTransactionDate = null;
            } else {
              _tmpTransactionDate = _cursor.getString(_cursorIndexOfTransactionDate);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            }
            final SyncState _tmpSyncState;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __syncStateConverter.toSyncState(_tmp_1);
            final boolean _tmpIsDeleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_2 != 0;
            final int _tmpVersion;
            _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
            _result = new TransactionEntity(_tmpId,_tmpServerId,_tmpAccountId,_tmpAccountName,_tmpAccountBalance,_tmpAccountCurrency,_tmpCategoryId,_tmpCategoryName,_tmpCategoryEmoji,_tmpIsIncome,_tmpAmount,_tmpTransactionDate,_tmpComment,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastSyncTime,_tmpSyncState,_tmpIsDeleted,_tmpVersion);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionByServerId(final int serverId,
      final Continuation<? super TransactionEntity> $completion) {
    final String _sql = "SELECT * FROM transactions WHERE serverId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, serverId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TransactionEntity>() {
      @Override
      @Nullable
      public TransactionEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfAccountName = CursorUtil.getColumnIndexOrThrow(_cursor, "accountName");
          final int _cursorIndexOfAccountBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "accountBalance");
          final int _cursorIndexOfAccountCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "accountCurrency");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
          final int _cursorIndexOfCategoryEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryEmoji");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
          final TransactionEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getInt(_cursorIndexOfServerId);
            }
            final int _tmpAccountId;
            _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            final String _tmpAccountName;
            if (_cursor.isNull(_cursorIndexOfAccountName)) {
              _tmpAccountName = null;
            } else {
              _tmpAccountName = _cursor.getString(_cursorIndexOfAccountName);
            }
            final String _tmpAccountBalance;
            if (_cursor.isNull(_cursorIndexOfAccountBalance)) {
              _tmpAccountBalance = null;
            } else {
              _tmpAccountBalance = _cursor.getString(_cursorIndexOfAccountBalance);
            }
            final String _tmpAccountCurrency;
            if (_cursor.isNull(_cursorIndexOfAccountCurrency)) {
              _tmpAccountCurrency = null;
            } else {
              _tmpAccountCurrency = _cursor.getString(_cursorIndexOfAccountCurrency);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpCategoryName;
            if (_cursor.isNull(_cursorIndexOfCategoryName)) {
              _tmpCategoryName = null;
            } else {
              _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            }
            final String _tmpCategoryEmoji;
            if (_cursor.isNull(_cursorIndexOfCategoryEmoji)) {
              _tmpCategoryEmoji = null;
            } else {
              _tmpCategoryEmoji = _cursor.getString(_cursorIndexOfCategoryEmoji);
            }
            final boolean _tmpIsIncome;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp != 0;
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpTransactionDate;
            if (_cursor.isNull(_cursorIndexOfTransactionDate)) {
              _tmpTransactionDate = null;
            } else {
              _tmpTransactionDate = _cursor.getString(_cursorIndexOfTransactionDate);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            }
            final SyncState _tmpSyncState;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __syncStateConverter.toSyncState(_tmp_1);
            final boolean _tmpIsDeleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_2 != 0;
            final int _tmpVersion;
            _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
            _result = new TransactionEntity(_tmpId,_tmpServerId,_tmpAccountId,_tmpAccountName,_tmpAccountBalance,_tmpAccountCurrency,_tmpCategoryId,_tmpCategoryName,_tmpCategoryEmoji,_tmpIsIncome,_tmpAmount,_tmpTransactionDate,_tmpComment,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastSyncTime,_tmpSyncState,_tmpIsDeleted,_tmpVersion);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionsBySyncState(final SyncState syncState,
      final Continuation<? super List<TransactionEntity>> $completion) {
    final String _sql = "SELECT * FROM transactions WHERE syncState = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __syncStateConverter.fromSyncState(syncState);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionEntity>>() {
      @Override
      @NonNull
      public List<TransactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfAccountName = CursorUtil.getColumnIndexOrThrow(_cursor, "accountName");
          final int _cursorIndexOfAccountBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "accountBalance");
          final int _cursorIndexOfAccountCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "accountCurrency");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
          final int _cursorIndexOfCategoryEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryEmoji");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
          final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getInt(_cursorIndexOfServerId);
            }
            final int _tmpAccountId;
            _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            final String _tmpAccountName;
            if (_cursor.isNull(_cursorIndexOfAccountName)) {
              _tmpAccountName = null;
            } else {
              _tmpAccountName = _cursor.getString(_cursorIndexOfAccountName);
            }
            final String _tmpAccountBalance;
            if (_cursor.isNull(_cursorIndexOfAccountBalance)) {
              _tmpAccountBalance = null;
            } else {
              _tmpAccountBalance = _cursor.getString(_cursorIndexOfAccountBalance);
            }
            final String _tmpAccountCurrency;
            if (_cursor.isNull(_cursorIndexOfAccountCurrency)) {
              _tmpAccountCurrency = null;
            } else {
              _tmpAccountCurrency = _cursor.getString(_cursorIndexOfAccountCurrency);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpCategoryName;
            if (_cursor.isNull(_cursorIndexOfCategoryName)) {
              _tmpCategoryName = null;
            } else {
              _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            }
            final String _tmpCategoryEmoji;
            if (_cursor.isNull(_cursorIndexOfCategoryEmoji)) {
              _tmpCategoryEmoji = null;
            } else {
              _tmpCategoryEmoji = _cursor.getString(_cursorIndexOfCategoryEmoji);
            }
            final boolean _tmpIsIncome;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp_1 != 0;
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpTransactionDate;
            if (_cursor.isNull(_cursorIndexOfTransactionDate)) {
              _tmpTransactionDate = null;
            } else {
              _tmpTransactionDate = _cursor.getString(_cursorIndexOfTransactionDate);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            }
            final SyncState _tmpSyncState;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __syncStateConverter.toSyncState(_tmp_2);
            final boolean _tmpIsDeleted;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_3 != 0;
            final int _tmpVersion;
            _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
            _item = new TransactionEntity(_tmpId,_tmpServerId,_tmpAccountId,_tmpAccountName,_tmpAccountBalance,_tmpAccountCurrency,_tmpCategoryId,_tmpCategoryName,_tmpCategoryEmoji,_tmpIsIncome,_tmpAmount,_tmpTransactionDate,_tmpComment,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastSyncTime,_tmpSyncState,_tmpIsDeleted,_tmpVersion);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionsByAnyOfSyncStates(final List<? extends SyncState> syncStates,
      final Continuation<? super List<TransactionEntity>> $completion) {
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM transactions WHERE syncState IN (");
    final int _inputSize = syncStates.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (SyncState _item : syncStates) {
      final String _tmp = __syncStateConverter.fromSyncState(_item);
      if (_tmp == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _tmp);
      }
      _argIndex++;
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionEntity>>() {
      @Override
      @NonNull
      public List<TransactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfAccountName = CursorUtil.getColumnIndexOrThrow(_cursor, "accountName");
          final int _cursorIndexOfAccountBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "accountBalance");
          final int _cursorIndexOfAccountCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "accountCurrency");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
          final int _cursorIndexOfCategoryEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryEmoji");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfVersion = CursorUtil.getColumnIndexOrThrow(_cursor, "version");
          final List<TransactionEntity> _result = new ArrayList<TransactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionEntity _item_1;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Integer _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getInt(_cursorIndexOfServerId);
            }
            final int _tmpAccountId;
            _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            final String _tmpAccountName;
            if (_cursor.isNull(_cursorIndexOfAccountName)) {
              _tmpAccountName = null;
            } else {
              _tmpAccountName = _cursor.getString(_cursorIndexOfAccountName);
            }
            final String _tmpAccountBalance;
            if (_cursor.isNull(_cursorIndexOfAccountBalance)) {
              _tmpAccountBalance = null;
            } else {
              _tmpAccountBalance = _cursor.getString(_cursorIndexOfAccountBalance);
            }
            final String _tmpAccountCurrency;
            if (_cursor.isNull(_cursorIndexOfAccountCurrency)) {
              _tmpAccountCurrency = null;
            } else {
              _tmpAccountCurrency = _cursor.getString(_cursorIndexOfAccountCurrency);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpCategoryName;
            if (_cursor.isNull(_cursorIndexOfCategoryName)) {
              _tmpCategoryName = null;
            } else {
              _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            }
            final String _tmpCategoryEmoji;
            if (_cursor.isNull(_cursorIndexOfCategoryEmoji)) {
              _tmpCategoryEmoji = null;
            } else {
              _tmpCategoryEmoji = _cursor.getString(_cursorIndexOfCategoryEmoji);
            }
            final boolean _tmpIsIncome;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp_1 != 0;
            final String _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            }
            final String _tmpTransactionDate;
            if (_cursor.isNull(_cursorIndexOfTransactionDate)) {
              _tmpTransactionDate = null;
            } else {
              _tmpTransactionDate = _cursor.getString(_cursorIndexOfTransactionDate);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            }
            final SyncState _tmpSyncState;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __syncStateConverter.toSyncState(_tmp_2);
            final boolean _tmpIsDeleted;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_3 != 0;
            final int _tmpVersion;
            _tmpVersion = _cursor.getInt(_cursorIndexOfVersion);
            _item_1 = new TransactionEntity(_tmpId,_tmpServerId,_tmpAccountId,_tmpAccountName,_tmpAccountBalance,_tmpAccountCurrency,_tmpCategoryId,_tmpCategoryName,_tmpCategoryEmoji,_tmpIsIncome,_tmpAmount,_tmpTransactionDate,_tmpComment,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastSyncTime,_tmpSyncState,_tmpIsDeleted,_tmpVersion);
            _result.add(_item_1);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getLastSyncTime(final SyncState syncState,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT MAX(lastSyncTime) FROM transactions WHERE syncState = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __syncStateConverter.fromSyncState(syncState);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUnsyncedTransactionsCount(final List<? extends SyncState> states,
      final Continuation<? super Integer> $completion) {
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT COUNT(*) FROM transactions WHERE syncState IN (");
    final int _inputSize = states.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (SyncState _item : states) {
      final String _tmp = __syncStateConverter.fromSyncState(_item);
      if (_tmp == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _tmp);
      }
      _argIndex++;
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
