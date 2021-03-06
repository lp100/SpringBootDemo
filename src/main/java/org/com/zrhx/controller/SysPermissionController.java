package org.com.zrhx.controller;

import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.com.zrhx.model.SysPermission;
import org.com.zrhx.service.SysPermissionService;
import org.com.zrhx.service.impl.SysPermissionServiceImpl;
import org.com.zrhx.utill.Constants;
import org.com.zrhx.utill.R;
import org.com.zrhx.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: SysPermissionController
 * @Description:  系统权限
 * @author: gs
 * @date: 2017/6/7 16:54
 */
@RestController
@RequestMapping("/sys/menu")
public class SysPermissionController extends BaseController<SysPermissionController> {
	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 所有菜单列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:menu:list")
	public R list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows, SysPermission params){
		PageInfo<SysPermission> pageInfo = sysPermissionService.findPageListByWhere(page,rows,params);
		return R.page(pageInfo.getSize(),pageInfo.getList());
	}



	/**
	 * 用户权限列表（菜单权限）
	 */
	@RequestMapping("/user")
	public R user() {
		String userId = ShiroUtils.getUserId();
		if (Constants.ADMINISTRATOR_USERID.equals(userId)){
			List<SysPermission> menuList = sysPermissionService.findListByWhere(null);
			return R.ok().put("menuList", menuList);
		}else{
			List<SysPermission> menuList = sysPermissionService.queryUserList(ShiroUtils.getUserId());
			return R.ok().put("menuList", menuList);
		}



	}

}
