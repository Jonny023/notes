------------------------
jvm						|
------------------------
	# �ο�
		https://blog.csdn.net/antony9118/article/details/51375662
		https://blog.csdn.net/coderlius/article/details/79272773
	
	# HotSpot VM
	
	# ���ڴ���з�
		* ������	1/3
			- Eden					80%
				* ��������, ����ڴ�
				* �������̫��, ��ֱ�ӷ��������
				* ����ڴ治��, �ᴥ��һ��: Minor GC

			- From Survivor			10%
				* ��һ��GC���Ҵ����, ��Ϊ��һGC�ı�ɨ����

			- TO Survivor			10%
				* ������һ�� Minor GC �е��Ҵ���
				

		* �����	2/3


------------------------
GC						|
------------------------
	# Minor GC
		* ��������ռ�(���� Eden �� Survivor ����)�����ڴ�
		* Minor GC ���ᴥ�� stop-the-world, ���ø����㷨
		* GC����
			1. �Ѵ������ Eden/From Survivor ���Ƶ� To Survivor , �������� +1, 
				* ����ж������䵽��������, �ƶ��������
				* ��� To Survivor �ڴ治��, �ͷŵ������
			
			2. ��� Eden/From Survivor �еĶ���
			3. From Survivor �� To Survivor ����
				* ԭ���� To Survivor ��Ϊ��һ�� GC �� From Survivor


	# Full GC/Major GC
		* Major GC ָ����, ���������, һ�㶼�����һ�� Minor GC(�Ǿ��Ե�), Ҳ���γ��� Full GC
		* �ٶȺ���, �� Minor GC ��10������, ���ñ������㷨
		* ����ɨ��������, ��Ǵ�����, ����û����ǵĶ���, ������ڴ���Ƭ
		* Ϊ�˼����ڴ�����, ����Ҫ���кϲ�

------------------------
�����漰�������ʽ���	|
------------------------
	# ����
		* ���GC�ռ����߳���ͬʱ�Ĺ���, ����Ӧ���̴߳�����ֹ״̬

	# ����
		* Ӧ���̺߳�GC�ռ��߳�ͬʱ(��ΪCPU������������,���ܻύ��ִ��)ִ��
	
	# promotion failed
		* Minor GCʱ, survivor space�Ų���, ����ֻ�ܷ��������, ����ʱ�����Ҳ�Ų���, �ᴥ�� Full GC

	# Concurrent Mode Failure 
		* Concurrent Mode Failure ����ִ���ռ���ʱ��, �����ڳ��ڴ���������е�ҵ���߳�
		* ��ʱ����ʱ����:Serial Old �ռ��������¶���������������ռ�

------------------------
����Full GC�Ŀ���		|
------------------------
	# ����Full GC��ʱ�򾭳���������һ�ε�Minor GC,���Ǿ��Ե�
		* Major GC���ٶ�һ����Minor GC��10 ������

	# ִ�� System.gc()
		* ִ�и÷����ǽ���jvm���� Full GC, ����JVM��һ�������ִ�� Full GC, ���Ǵ󲿷ֶ��ǻ�ִ��Full GC��

	# ��������ռ䲻��
		* ������ռ�ֻ��������������ת�뼰����Ϊ�����, ������ʱ�Ż���ֲ��������
		* ��ִ��Full GC��ռ���Ȼ����, ���׳��쳣:java.lang.OutOfMemoryError: Java heap space 
	
	
	# CMS GCʱ���� promotion failed ��concurrent mode failure
		* promotion failed ���ڽ���Minor GCʱ, survivor space�Ų���, ����ֻ�ܷ��������, ����ʱ�����Ҳ�Ų�����ɵ�
		* concurrent mode failure ����ִ��CMS GC�Ĺ�����ͬʱ�ж���Ҫ���������, ����ʱ������ռ䲻����ɵ�(��������)
	
	# ����ʧ��
		* Minor GC ֮ǰ, JVMҪ�����������õ���������ռ��Ƿ�������������ж�����ܿռ�(Ϊ��Ӧ�������������ж��󶼴������)
		* Ҫ������������ڴ�ռ�С�����������ж������ڴ��С�ռ�, ����С�����ν��������������(�ܴ�С)��ƽ����С, ��ִ�� Full GC
	



------------------------
һ���̷߳�������		|
------------------------
	1. JSP ȷ��Java�Ľ���ID: 18392
		
	2. ʹ��jstack����java���߳��б�
		jstack -l 18392 > 18392.stack

	3. ʹ��top -Hp 18392 -d1 ����鿴java����������̵߳�ʵ��ռ��
		* ��¼id��͵�����stack�ļ��ȶ�, ����֪�������������ռ��
		* ���߳��б�����,�̵߳ĵ�id����16���Ʊ�ʾ��, ���ƽ���:nid
			nid=0x47d8
	

	# ����ʹ��רҵ�������߳�dump����ƽ̨
		https://fastthread.io/