
##Answer 1:         SELECT SUM(claimed_charge) FROM document WHERE status = 'EXPORTED';

##Answer 2:         SELECT batch.customer_id, document.insured_name,
                    document.insured_address ,document.claimed_charge
                    FROM document INNER JOIN batch
                    on batch.id =document.batch_id
                    WHERE document.status ="TO_REPRICE" AND
                    (batch.customer_id=1 OR batch.customer_id=2);