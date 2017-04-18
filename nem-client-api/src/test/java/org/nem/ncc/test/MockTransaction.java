package org.nem.ncc.test;

import org.nem.core.model.*;
import org.nem.core.model.observers.TransactionObserver;
import org.nem.core.serialization.*;
import org.nem.core.time.TimeInstant;

import java.util.*;

/**
 * A mock Transaction implementation.
 */
public class MockTransaction extends Transaction {

	public static final int TYPE = 124;
	public static final int VERSION = 758;
	public static final TimeInstant TIMESTAMP = new TimeInstant(1122448);
	public static final TimeInstant DEADLINE = TIMESTAMP.addHours(2);

	private final int customField;

	/**
	 * Creates a mock transaction.
	 */
	public MockTransaction() {
		this(Utils.generateRandomAccount());
	}

	/**
	 * Creates a mock transaction.
	 *
	 * @param sender The transaction sender's account.
	 */
	public MockTransaction(final Account sender) {
		this(sender, 0);
	}

	/**
	 * Creates a mock transaction.
	 *
	 * @param sender The transaction sender's account.
	 * @param customField The initial custom field value.
	 */
	public MockTransaction(final Account sender, final int customField) {
		super(TYPE, VERSION, TIMESTAMP, sender);
		this.customField = customField;
		this.setDeadline(DEADLINE);
	}

	/**
	 * Creates a mock transaction.
	 * This overload is intended to be used for comparison tests.
	 *
	 * @param customField The initial custom field value.
	 * @param timeStamp The transaction timestamp.
	 */
	public MockTransaction(final int customField, final TimeInstant timeStamp) {
		super(TYPE, VERSION, timeStamp, Utils.generateRandomAccount());
		this.customField = customField;
		this.setDeadline(timeStamp.addHours(2));
	}

	/**
	 * Deserializes a MockTransaction.
	 *
	 * @param deserializer The deserializer to use.
	 * @param options The deserialization options.
	 */
	public MockTransaction(final Deserializer deserializer, final DeserializationOptions options) {
		super(deserializer.readInt("type"), options, deserializer);
		this.customField = deserializer.readInt("customField");
	}

	@Override
	protected Collection<Account> getOtherAccounts() {
		return new ArrayList<>();
	}

	@Override
	protected void serializeImpl(final Serializer serializer) {
		super.serializeImpl(serializer);
		serializer.writeInt("customField", this.customField);
	}

	@Override
	protected void transfer(final TransactionObserver transactionObserver, final TransactionExecutionState state) {
	}
}