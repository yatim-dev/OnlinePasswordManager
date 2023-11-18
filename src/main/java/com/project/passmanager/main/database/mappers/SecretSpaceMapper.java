//package com.project.passmanager.main.database.mappers;
//
//
//import com.project.passmanager.main.database.models.SecretSpaceEntity;
//import com.project.passmanager.main.domain.models.SecretSpace;
//
///**
// * маппинг модели SecretSpace слоев domain и database
// * */
//public class SecretSpaceMapper {
//    public static SecretSpaceEntity transform(SecretSpace secretSpace) {
//        return new SecretSpaceEntity(
//                Long.parseLong(secretSpace.getId()),
//                Long.parseLong(secretSpace.getF_key()),
//                secretSpace.getName()
//        );
//    }
//
//    public static SecretSpace transform(SecretSpaceEntity secretSpaceEntity) {
//        return new SecretSpace(
//                secretSpaceEntity.getId().toString(),
//                secretSpaceEntity.getUser().getId().toString(),
//                secretSpaceEntity.getName()
//        );
//    }
//}