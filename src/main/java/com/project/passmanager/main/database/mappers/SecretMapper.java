//package com.project.passmanager.main.database.mappers;
//
//import com.project.passmanager.main.database.models.SecretEntity;
//import com.project.passmanager.main.domain.models.Secret;
//
//import java.util.List;
//
///**
// * маппинг модели Secret слоев domain и database
// * */
//public class SecretMapper {
//    public static SecretEntity transform(Secret secret) {
//        return new SecretEntity(
//                secret.getId(),
//                secret.getSecretSpaceId(),
//                secret.getName(),
//                secret.getLogin(),
//                secret.getPassword(),
//                secret.getNote()
//        );
//    }
//
//    public static List<SecretEntity> transformToSecretsEntity(List<Secret> secrets) {
//        return secrets
//                .stream()
//                .map(SecretMapper::transform)
//                .toList();
//    }
//
//    public static Secret transform(SecretEntity secretEntity) {
//        return new Secret(
//                secretEntity.getId(),
//                secretEntity.getSecretSpaceId(),
//                secretEntity.getName(),
//                secretEntity.getLogin(),
//                secretEntity.getPassword(),
//                secretEntity.getNote()
//        );
//    }
//
//    public static List<Secret> transformToSecrets(List<SecretEntity> secrets) {
//        return secrets
//                .stream()
//                .map(SecretMapper::transform)
//                .toList();
//    }
//}
