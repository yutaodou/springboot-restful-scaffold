CREATE TABLE todo
(
    id         BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ToDo ID',
    title      VARCHAR(255) DEFAULT NULL COMMENT '标题',
    created_by VARCHAR(100) NOT NULL COMMENT '创建人',
    created_at TIMESTAMP    DEFAULT NOW() COMMENT '创建时间',
    updated_by VARCHAR(100) COMMENT '最后更新人',
    updated_at TIMESTAMP    DEFAULT NOW() COMMENT '最后更新时间'
)
