//package com.example.demo.recursive
//
//import com.ztc.xa.project.task.model.AssessItem
//import java.io.Serializable
//import java.math.BigDecimal
//import java.util.*
//
//
///**
// * @ClassName: AssessItemVO
// * @Description: VO
// * @author cfy
// * @date 2021-05-11
// */
//class AssessItemNoticeVO : Serializable {
//
//    /**
//     * 考核项主键id
//     */
//    var itemId:String? = null
//
//    /**
//     * 考核项名称
//     */
//    var itemName:String? = null
//
//    /**
//     * 父id
//     */
//    var parentId:String? = null
//
//    /**
//     * 父名称
//     */
//    var parentName:String? = null
//
//    /**
//     * 默认分
//     */
//    var defaultScore: BigDecimal? = null
//
//    /**
//     * 执行人角色,1:开发人员,2:PM,3:职能人员,4:PMO,5:EPG,6:QA
//     */
//    var executorRole:String? = null
//
//    /**
//     * 创建时间
//     */
//    var createdAt:Date? = null
//
//    /**
//     * 更新时间
//     */
//    var updatedAt:Date? = null
//
//    /**
//     * 考核类型,1:项目,2:项目管理人员
//     */
//    var assessType: String? = null
//
//    /**
//     * 项目Id
//     */
//    var projectId: String? = null
//
//    /**
//     * 项目管理用户Id
//     */
//    var managerId: String? = null
//
//}