--------------------------------
stdio							|
--------------------------------

EOF
	* -1,表示文件结尾

printf()
	* 用于标注输出(打印)
	* 支持字符串占位符,必须严格按照占位符的数据类型传递参数
		printf("Hello %d,%d",5,6);

puts()
	* 函数只用来输出字符串,不能使用占位符,自动添加换行
	* 里面的参数可以直接是字符串或者是存放字符串的字符数组名
	* 作用与 printf("%s\n",s);的作用形同

scanf()
	* 获取屏幕输入,跟 printf 一样,也可以使用格式字符串和参数列表
	* scanf 在读取的时候,会跳过所有非空白符前面的空白符
	* printf函数使用便利,常量和表达式,scanf函数使用变量的指针
		int var1;
		int var2;
		scanf("%d %d",&var1,&var2);
		printf("%d %d",var1,var2);

	* 当用户通过scanf输入字符时,编译器默认先把内容放在缓冲区
	* scanf自动在缓冲区读取内容


getchar()
	* 读取下一个字符串输入,并且返回,它只处理字符
	* 等同于
		char ch;
		scanf("%c",&ch);

putchar()
	* 该函数的作用就是,打印该函数的参数,它只处理字符
	* 等同于
		char ch = '1';
		printf("%d",ch)