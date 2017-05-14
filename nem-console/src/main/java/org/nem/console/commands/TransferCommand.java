package org.nem.console.commands;

import org.apache.commons.cli.*;
import org.nem.core.messages.PlainMessage;
import org.nem.core.model.*;
import org.nem.core.model.primitive.Amount;
import org.nem.core.time.TimeInstant;
import org.nem.core.utils.StringEncoder;

import java.util.function.Function;

/**
 * A command for generating a transfer.
 */
public class TransferCommand extends TransactionCommand {

	/**
	 * Creates a transfer command.
	 */
	public TransferCommand() {
		super("transfer");
	}

	@Override
	protected Transaction createTransaction(
			final TimeInstant timeStamp,
			final Account sender,
			final Function<String, Account> accountLookup,
			final CommandLine commandLine) {
		final Account recipient = accountLookup.apply(commandLine.getOptionValue("recipient"));
		final long amount = Long.parseLong(commandLine.getOptionValue("amount"));
		System.out.println(String.format("transfer (%s) '%s' -> '%s'", amount, sender, recipient));

		TransferTransactionAttachment attachment = null;
		if (commandLine.hasOption("message")) {
			final Message message = new PlainMessage(StringEncoder.getBytes(commandLine.getOptionValue("message")));
			attachment = new TransferTransactionAttachment(message);
		}

		return new TransferTransaction(
				timeStamp,
				sender,
				recipient,
				Amount.fromMicroNem(amount),
				attachment);
	}

	@Override
	protected void addCustomOptions(final Options options) {
		options.addOption("recipient", true, "The recipient alias");
		options.addOption("amount", true, "The amount in micronem");
		options.addOption("message", true, "The optional message");
	}
}
