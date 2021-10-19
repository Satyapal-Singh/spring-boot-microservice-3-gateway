package com.sha.springbootmicroservice3gateway.controller;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.security.UserPrincipal;
import com.sha.springbootmicroservice3gateway.service.ITransactionService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/transaction")
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class TransactionController
{
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody JsonElement transaction)
    {
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId)
    {
        transactionService.deleteTransaction(transactionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactionsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal principal)
    {
        return ResponseEntity.ok(transactionService.getAllTransactionsOfUser(principal.getId()));
    }
}
