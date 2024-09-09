INSERT INTO `member` (`name`,`email`,`mobile_number`, `pwd`, `role`,`created_at`)
VALUES ('Happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE());

INSERT INTO `accounts` (`member_id`, `account_number`, `account_type`, `branch_address`, `created_at`)
VALUES (1, 1865764534, 'Savings', '123 Main Street, New York', CURDATE());


INSERT INTO `account_transactions` ( `account_number`, `member_id`, `transaction_at`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                     `closing_balance`, `created_at`)  VALUES ( 1865764534, 1, DATE_SUB(CURDATE(), INTERVAL 7 DAY), 'Coffee Shop', 'Withdrawal', 30,34500,DATE_SUB(CURDATE(), INTERVAL 7 DAY));

INSERT INTO `account_transactions` ( `account_number`, `member_id`, `transaction_at`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                     `closing_balance`, `created_at`)   VALUES (1865764534, 1, DATE_SUB(CURDATE(), INTERVAL 6 DAY), 'Uber', 'Withdrawal', 100,34400,DATE_SUB(CURDATE(), INTERVAL 6 DAY));

INSERT INTO `account_transactions` ( `account_number`, `member_id`, `transaction_at`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                     `closing_balance`, `created_at`)    VALUES (1865764534, 1, DATE_SUB(CURDATE(), INTERVAL 5 DAY), 'Self Deposit', 'Deposit', 500,34900,DATE_SUB(CURDATE(), INTERVAL 5 DAY));

INSERT INTO `account_transactions` ( `account_number`, `member_id`, `transaction_at`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                     `closing_balance`, `created_at`)    VALUES (1865764534, 1, DATE_SUB(CURDATE(), INTERVAL 4 DAY), 'Ebay', 'Withdrawal', 600,34300,DATE_SUB(CURDATE(), INTERVAL 4 DAY));

INSERT INTO `account_transactions` ( `account_number`, `member_id`, `transaction_at`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                     `closing_balance`, `created_at`)    VALUES (1865764534, 1, DATE_SUB(CURDATE(), INTERVAL 2 DAY), 'OnlineTransfer', 'Deposit', 700,35000,DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO `account_transactions` ( `account_number`, `member_id`, `transaction_at`, `transaction_summary`, `transaction_type`,`transaction_amt`,
                                     `closing_balance`, `created_at`)    VALUES ( 1865764534, 1, DATE_SUB(CURDATE(), INTERVAL 1 DAY), 'Amazon.com', 'Withdrawal', 100,34900,DATE_SUB(CURDATE(), INTERVAL 1 DAY));

INSERT INTO `loans` ( `member_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_at`)
VALUES ( 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');

INSERT INTO `loans` ( `member_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_at`)
VALUES ( 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');

INSERT INTO `loans` ( `member_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_at`)
VALUES ( 1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO `loans` ( `member_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_at`)
VALUES ( 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

INSERT INTO `cards` (`card_number`, `member_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_at`)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURDATE());

INSERT INTO `cards` (`card_number`, `member_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_at`)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURDATE());

INSERT INTO `cards` (`card_number`, `member_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_at`)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURDATE());


INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notice_beg_at`, `notice_end_at`, `created_at`, `updated_at`)
VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notice_beg_at`, `notice_end_at`, `created_at`, `updated_at`)
VALUES ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notice_beg_at`, `notice_end_at`, `created_at`, `updated_at`)
VALUES ('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notice_beg_at`, `notice_end_at`, `created_at`, `updated_at`)
VALUES ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notice_beg_at`, `notice_end_at`, `created_at`, `updated_at`)
VALUES ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);
INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notice_beg_at`, `notice_end_at`, `created_at`, `updated_at`)
VALUES ('COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);