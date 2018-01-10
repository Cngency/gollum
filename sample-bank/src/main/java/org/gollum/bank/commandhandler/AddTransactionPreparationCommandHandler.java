package org.gollum.bank.commandhandler;

import org.gollum.bank.Singleton;
import org.gollum.bank.command.AddTransactionPreparationCommand;
import org.gollum.bank.domain.account.BankAccount;
import org.gollum.bank.domain.account.BankAccountRepository;
import org.gollum.core.commanding.CommandHandler;
import org.gollum.core.common.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wurenhai
 * @date 2018/1/4
 */
@Component
@Singleton
public class AddTransactionPreparationCommandHandler implements CommandHandler<AddTransactionPreparationCommand> {

    @Autowired
    private BankAccountRepository repository;

    @Override
    public void exec(AddTransactionPreparationCommand command) {
        BankAccount bankAccount = repository.getById(command.getAggregateRootId(), BankAccount.class);
        Assertion.notNull(bankAccount, "bankAccount");
        int version = bankAccount.getVersion();
        bankAccount.addTransactionPreparation(command.getTransactionId(),
                command.getTransactionType(),
                command.getPreparationType(),
                command.getAmount());
        repository.commit(bankAccount, version);
    }

}