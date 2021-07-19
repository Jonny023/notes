--------------------------
Filter
--------------------------
	# ͨ��Ϊ����·�ɶ����ӹ�����
		spring:
		  cloud:
			gateway:
			  default-filters:
			    - AddResponseHeader=X-Response-Default-Red, Default-Blue
			    - PrefixPath=/httpbin
	
	# Filter�����ã�Ҳ��֧�ּ�/�������õ�
		

---------------------
GlobalFilter
---------------------
	# �ӿڶ���: GlobalFilter
		public interface GlobalFilter {
			Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain);
		}
		
	# GlobalFilter �Ĺ�����ʵ��GatewayFilter����ͬ�ģ�ֻ��GlobalFilter�������������е�·�����ã������ǰ���ָ����·�������ϡ�
	# ���GlobalFilter����ͨ�� @Orde r���� getOrder() ����ָ��ÿ�� GlobalFilter ��ִ��˳��
		* pre���͹��������orderֵԽС����ô����Ӧ����pre���������Ķ��㣬������֮ǰ����ִ��
		* post���͹��������orderֵԽС����ô����Ӧ����pre���������ĵײ㣬������֮������ִ��
	

	# �ڽ���GlobalFilter
		ForwardRoutingFilter		�ض���
		LoadBalancerClientFilter	���ؾ���
		NettyRoutingFilter			Netty��HTTP�ͻ��˵�·��
		NettyWriteResponseFilter	Netty��Ӧ����д����
		RouteToRequestUrlFilter		����·�����ø���URL
		WebsocketRoutingFilter		Websocket����ת��������
	

		