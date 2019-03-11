### Docker 常⽤命令
    镜像相关
    • docker pull <image>
    • docker search <image>
    容器相关
    • docker run
    • docker start/stop <容器名>
    • docker ps <容器名>
    • docker logs <容器名>
 ### docker run 的常⽤选项
    docker run [OPTIONS] IMAGE [COMMAND] [ARG…]
    选项说明
    • -d，后台运⾏容器
    • -e，设置环境变量
    • --expose / -p 宿主端⼝:容器端⼝
    • --name，指定容器名称
    • --link，链接不同容器
    • -v 宿主⽬录:容器⽬录，挂载磁盘卷
 ### 