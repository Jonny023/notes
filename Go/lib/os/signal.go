------------------------
signal
------------------------

------------------------
����
------------------------

------------------------
type
------------------------

------------------------
func
------------------------
	func Ignore(sig ...os.Signal)
	func Ignored(sig os.Signal) bool
	func Notify(c chan<- os.Signal, sig ...os.Signal)
		* ���ź�sig���ݸ�c�������ָ��sig�������е��źŶ��ᱻ����
		* һ�� c �Ļ�������С����Ϊ1���㹻

	func Reset(sig ...os.Signal)
	func Stop(c chan<- os.Signal)


------------------------
Demo
------------------------
	# ����2���ź�
		import (
			"fmt"
			"os"
			"os/signal"
			"time"
		)

		func main(){
			// �����ź�ͨ��
			signalChan := make(chan os.Signal, 1)
			// ע��ͨ������Ҫ�������ź�
			signal.Notify(signalChan, os.Interrupt, os.Kill)
			// �����ź��¼�
			go func() {
				for {
					sig := <- signalChan
					switch sig {
						case os.Interrupt: {
							fmt.Println("��Interrupt")
						}
						case os.Kill: {
							fmt.Println("��Kill")
						}
					}
				}
			}()

			for {
				fmt.Printf("runing ...")
				time.Sleep(20 * time.Second)
			}
		}
