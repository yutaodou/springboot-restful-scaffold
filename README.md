# Spring Boot API Scaffold

SpringBoot 后端 API 项目模板，按需裁剪相关设置

- JDK 17
- Gradle 7.5.1
- Spring Boot 2.7.5
- PMD
- Jacoco
- Spotless
- Editorconfig
- MySQL 8.0
- docker-compose

# 代码风格

## IDE 配置

使用`.editorconfig`统一管理代码风格，开发时确保IDE使用该配置.

## 自动代码格式化

设置`precommit` hook 完成代码提交前的自动格式化
可以通过如下命令配置Git pre commit hook

## commit 消息格式

格式：commitType: [TASK-ID] commitMessage

commitType 可选值：chore/docs/feat/fix/refactor/style/test

```shell
./gradlew installGitHooks
```

## 本地开发

```shell
# 启动服务
docker-compose up -d

# 停止服务
docker-compose down
```

项目集成了`org.springframework.boot:spring-boot-devtools`, 如果 class 文件发生变化，服务会自动重新加载，无需手动重新启动。

### 本地调试

服务启动时开启了远程调试，端口映射到本地 `5005`， 可以通过 IDEA连接到`本地 5005 端口` 远程调试

## 常用命令

### 运行所有检查

```shell
./gradlew check
```

### 运行单元测试

```shell
./gradlew test
```

### 运行集成测试

```shell
./gradlew integrationTest
```

### 运行代码静态检查

```shell
./gradlew pmdMain pmdTest
```

### 运行代码风格检查

```shell
./gradlew spotlessCheck
```

### 格式化代码

```shell
./gradlew spotlessApply
```




