package org.colorcoding.ibas.initialfantasy.test.bo;

import org.colorcoding.ibas.bobas.common.ICriteria;
import org.colorcoding.ibas.bobas.common.IOperationResult;
import org.colorcoding.ibas.initialfantasy.bo.approvaltemplate.ApprovalTemplate;
import org.colorcoding.ibas.initialfantasy.bo.approvaltemplate.IApprovalTemplateStep;
import org.colorcoding.ibas.initialfantasy.repository.BORepositoryInitialFantasy;
import org.colorcoding.ibas.initialfantasy.repository.IBORepositoryInitialFantasyApp;

import junit.framework.TestCase;

/**
 * 审批模板 测试
 * 
 */
public class testApprovalTemplate extends TestCase {
	/**
	 * 获取连接口令
	 */
	String getToken() {
		return "";
	}

	/**
	 * 基本项目测试
	 * 
	 * @throws Exception
	 */
	public void testBasicItems() throws Exception {
		ApprovalTemplate bo = new ApprovalTemplate();
		// 测试属性赋值

		// 测试审批模板步骤
		IApprovalTemplateStep approvaltemplatestep = bo.getApprovalTemplateSteps().create();
		// 测试属性赋值

		// 测试对象的保存和查询
		IOperationResult<?> operationResult = null;
		ICriteria criteria = null;
		IBORepositoryInitialFantasyApp boRepository = new BORepositoryInitialFantasy();
		// 设置用户口令
		boRepository.setUserToken(this.getToken());

		// 测试保存
		operationResult = boRepository.saveApprovalTemplate(bo);
		assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);
		ApprovalTemplate boSaved = (ApprovalTemplate) operationResult.getResultObjects().firstOrDefault();

		// 测试查询
		criteria = boSaved.getCriteria();
		criteria.setResultCount(10);
		operationResult = boRepository.fetchApprovalTemplate(criteria);
		assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);

	}

}
