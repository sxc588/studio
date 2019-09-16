package com.github;

import org.junit.Test;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;

public class ConsulService {
	static Consul consul = Consul.builder().withHostAndPort(HostAndPort.fromString("192.168.1.72:8500")).build();

	/**
	 * 服务注册
	 */
	public static void serviceRegister() {
		AgentClient agent = consul.agentClient();

		// 健康检测
		ImmutableRegCheck check = ImmutableRegCheck.builder()
				.http("http://maven.outofmemory.cn/com.orbitz.consul/consul-client/").interval("5s").build();

		ImmutableRegistration.Builder builder = ImmutableRegistration.builder();
		builder.id("tomcat1").name("tomcat").addTags("v1").address("192.168.1.104").port(8080).addChecks(check);

		agent.register(builder.build());
	}

	@Test
	public void aa() {
		KeyValueClient kk = consul.keyValueClient();

		String valu = kk.getValueAsString("support/supmonitor/database/password").get();
		System.err.println(valu);
	}

}