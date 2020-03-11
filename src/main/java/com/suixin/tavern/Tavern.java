package com.suixin.tavern;

import com.suixin.tavern.handler.BetDataHandler;
import com.suixin.tavern.util.JdbcUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class Tavern extends JavaPlugin {
	private BetDataHandler betDataHandler;
	@Override
	public void onEnable() {
		this.betDataHandler = new BetDataHandler(this);
		getLogger().info("==================[Tavern]==================");
		try {
			boolean connection = new JdbcUtil().openConnection(this.betDataHandler);//加载数据库驱动
			if (connection) {
				getLogger().info("Mysql连接成功");
			}
		}catch (Exception e){
			getLogger().info("Mysql连接失败:"+e.getMessage());
			getLogger().info("如有疑问，请联系开发人员解决：QQ:2469012478");
		}
		getLogger().info("==================[Tavern]==================");
	}
}
