

DROP DATABASE freight_transport;
CREATE DATABASE freight_transport DEFAULT  CHARSET utf8;
USE freight_transport;
#1管理员表
CREATE TABLE manager(
m_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
m_account VARCHAR(100)    COMMENT '账号',
m_password VARCHAR(100)    COMMENT '密码',
m_phone VARCHAR(100)    COMMENT '手机号码',
m_rank VARCHAR(50)    COMMENT '权限',
m_remarks VARCHAR(256) COMMENT '备注'
);
INSERT INTO `manager` VALUES ('1', 'admin', '123456','18776203778', '高级管理员', '1000');
INSERT INTO `manager` VALUES ('2', 'mydb', '123456','18776202228',  '普通管理员', '500');
INSERT INTO `manager` VALUES ('3', 'tom', '123456','4565645665',  '普通管理员', '1000');

#2财务信息表
CREATE TABLE financial_info_sheet(
f_id INT PRIMARY KEY AUTO_INCREMENT  COMMENT '编号',
f_befor_money DECIMAL(10,2) COMMENT '交易前余额',
f_after_money DECIMAL(10,2) COMMENT '交易后余额',
f_money DECIMAL(10,2) COMMENT '交易余额',
f_type VARCHAR(100) COMMENT '交易类型',
f_name_type VARCHAR(100) COMMENT '交易人类型',
f_ids INT COMMENT '交易人id',
f_name VARCHAR(100) COMMENT '交易人名字',
f_date DATETIME  COMMENT '交易时间',
f_remarks VARCHAR(256) COMMENT '备注'
);
INSERT INTO `financial_info_sheet` VALUES ('1','1000','500','500','充值','司机','001','admin','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('2','1000','500','500','充值','司机','002','mydb','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('3','1000','500','500','充值','货主','003','moonLu','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('4','1000','500','500','充值','货主','004','bonZhang','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('5','1000','500','500','支付','货主','005','davidJiang','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('6','1000','500','500','支付','货主','006','jamesHou','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('7','1000','500','500','支付','货主','007','helenguan','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('8','1000','500','500','提现','货主','008','lenaKong','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('9','1000','500','500','提现','货主','009','Juneyang','20190109','');
INSERT INTO `financial_info_sheet` VALUES ('10','1000','500','500','提现','司机','010','ally','20190109','');


#3员工表


CREATE TABLE staff_info(
s_no INT PRIMARY KEY AUTO_INCREMENT COMMENT '员工编号',
s_name VARCHAR(100) COMMENT '员工姓名',
s_sex VARCHAR(10) COMMENT '性别',
s_birthhday DATE COMMENT '出生日期',
s_phone VARCHAR(50) COMMENT '手机号码' ,
s_password VARCHAR(256) COMMENT '密码',
s_firm_name VARCHAR(100) COMMENT '公司名称',
s_remarks VARCHAR(256) COMMENT '备注'
);
INSERT INTO `staff_info`(s_name,s_sex,s_birthhday,s_phone,s_password,s_firm_name,s_remarks) VALUES
 ('ZhangSan', '男', '1996-01-03', '234324454', '123', 'ZS', '12300'),
 ('LiSi', '女', '1996-01-23', '234344555', '123', 'LS', '12000'),
 ('WangWu', '男', '1996-01-15', '123433433', '123', 'WW', '20000'),
 ('ZhaoLiu', '女', '1996-07-20', '324455464', '123', 'ZL', '20000'),
 ('SunQi', '男', '1996-11-03', '234565656', '123', 'SQ', '12000'),
 ('WangXiaoer','男','1997-01-20','234778288','456','WX','10000'),
 ('ZhouJielun','男','1996-02-12','375866478','123','ZJl','15000'),
 ('ZhanYishan','男','1992-01-23','347885655','456','ZYs','12500'),
 ('LiuYifei','女','1992-08-17','134878767','123','LYf','15000'),
 ('ZhangFengyi','男','1970-03-15','234635567','123','ZFy','13000'),
 ('XuSong','男','1990-08-10','764876786','123','XS','18000'),
 ('ChenChong','女','1996-08-25','768768377','456','CC','25000'),
 ('WangSulong','男','1992-08-09','686868789','789','WSl','30000'),
 ('DengZiqi','女','1988-02-10','987872782','789','DZq','50000'),
 ('ZhaoFangjing','女','1992-02-17','767523866','456','ZFj','27000'),
 ('YangZi','女','1992-03-27','623825837','456','YZ','20000'),
 ('LinJunjie','男','1990-11-23','686328682','789','LJj','19000'),
 ('GaoShijie','男','1978-12-10','973823971','123','GSj','23000'),
 ('GuoYongwei','男','1999-01-02','634826482','123','GYw','12000');
 
 
#4货主
CREATE TABLE shipper_info(
s_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '货主编号',
s_name VARCHAR(100) COMMENT '货主姓名',
s_sex VARCHAR(10) COMMENT '货主性别',
s_phone VARCHAR(50) COMMENT '手机号码' ,
s_password VARCHAR(100) COMMENT '密码',
s_uuid VARCHAR(100) COMMENT '身份证号码',
s_balance DECIMAL(10,2) COMMENT '余额',
s_register_date DATETIME COMMENT '注册时间',
s_remarks VARCHAR(256) COMMENT '备注'
);
INSERT INTO `shipper_info`(s_name,s_sex,s_phone,s_password,s_uuid,s_balance) VALUES
 ('as', '男',  '1234345546', '123', '001', '0'),
( 'asd', '女',  '3455567776', '123', '002', '0'),
('adsa', '男',  '545667567', '123', '003', '100'),
('qe', '男',  '2347846888', '123', '004', '100'),
( 'tw', '女',  '7384584678', '123', '005', '1'),
( 'ewr', '女',  '3474678478', '123', '006', '5'),
( 'res','女', '235564565', '456', '007', '007'),
( 'dis','男', '475862477', '123', '008' ,'233'),
( 'vuess','女', '757365573' ,'123', '009', '235'),
( 'csse', '男', '887849748', '123', '010', '145'),
( 'kim', '男', '457578678', '456', '011', '290'),
( 'Dali', '女', '877438692','234', '012', '237'),
( 'tyh', '男', '344534345', '345', '013', '013'),
( 'oppo', '女', '987926399', '123', '014', '709'),
( 'Xin', '男', '787634768', '123', '015', '987');

#5司机
CREATE TABLE driver_info(
d_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
d_name VARCHAR(100) COMMENT '姓名',
d_sex VARCHAR(10) COMMENT '性别',
d_uuid VARCHAR(100) COMMENT '身份证号码',
d_phone VARCHAR(50) COMMENT '手机号码' ,
d_password VARCHAR(50) COMMENT '密码',
d_card VARCHAR(1000) COMMENT '油卡',
d_balance DECIMAL(10,2) COMMENT '余额',
d_register_date DATETIME  COMMENT '注册时间',
d_s_remarks VARCHAR(256) COMMENT '备注'
);
INSERT INTO `driver_info`(d_name,d_sex,d_uuid,d_phone,d_password,d_card,d_balance) VALUES
 ('admin', '男', '001', '1234345546', '123', '001', '0.00'),
( 'mydb', '女', '002', '3455567776', '123', '002', '0.00'),
('tom', '男', '003', '545667567', '123', '003', '1.00'),
('jack', '男', '004', '2347846888', '123', '004', '1.00'),
( 'tony', '女', '005', '7384584678', '123', '005', '0.00'),
( 'jenny', '女', '006', '3474678478', '123', '006', '1.00'),
( 'Chenchong', '男', '007', '433247828', '123', '007', '1.00'),
( 'LiuSongfeng', '男', '008', '657525467', '456', '008', '1.00'),
( 'ShiFuming', '男', '009', '084837938', '123', '009', '1.00'),
( 'GuoYongwei', '男', '010', '897246899', '123', '010', '0.00'),
( 'DuHaixin', '男', '011', '234342442', '456', '011', '0.00'),
( 'YangHanxiang', '男', '012', '788747282', '123', '012', '1.00'),
( 'ZhangShilong', '男' ,'013', '976836826', '123', '013', '0.00'),
( 'Liujiamei', '男', '014', '908798398', '456', '014', '1.00'),
( 'YanJiali', '女', '015', '782638863', '123', '015', '1.00');

#6车辆类型
CREATE TABLE vehicle_type(
t_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
v_name VARCHAR(50)  COMMENT '类型名称',
v_load VARCHAR(50) COMMENT '载重',
v_zgk VARCHAR(50) COMMENT '长宽高',
v_s  VARCHAR(50) COMMENT '载货体积'
);
INSERT INTO `vehicle_type`(v_name,v_load,v_zgk,v_s) VALUES
 ( '小型车', '5', '5X4X3', '500'),
 ( '中型车', '15', '321', '1000'),
 ( '大型车', '20', '321', '1500');

#7车辆信息表
CREATE TABLE vehicle_info(
v_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
v_license VARCHAR(50)  COMMENT '车牌号',
v_type VARCHAR(50) COMMENT '品牌',
v_color VARCHAR(50) COMMENT '车颜色',
t_type INT COMMENT '车辆类型',
d_id INT COMMENT '司机编号',
v_remarks VARCHAR(256) COMMENT '备注'
);
INSERT INTO `vehicle_info`(v_license,v_type,v_color,t_type,d_id,v_remarks) VALUES
 ( '0102u5', '法拉第', 'green', '1', '1', NULL),
 ( '0103u5', '宝马', 'green', '1', '2', NULL),
 ( '0104u5', '宝马', 'green', '1', '3', NULL),
 ( '0105u5', '奥迪', 'green', '1', '4', NULL),
 ( '0107d5', '奔驰', 'green', '1', '12', NULL);

#8公告表
CREATE TABLE notice(
n_infro_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
n_content VARCHAR(200) COMMENT '内容',
n_direction VARCHAR(100)  COMMENT '标题'
);
INSERT INTO notice(n_content,n_direction)VALUES('司机内容','司机');
INSERT INTO notice(n_content,n_direction)VALUES('货主内容','货主');
INSERT INTO notice(n_content,n_direction)VALUES('管理员内容','管理员');

#9平台收取费用表
CREATE TABLE collect_fees(
c_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
c_date VARCHAR(200) COMMENT '时间/分钟',
c_mileage VARCHAR(100) COMMENT '里程/分钟',
c_starting VARCHAR(100) COMMENT '起步价',
c_remarks VARCHAR(100) COMMENT '备注',
c_type VARCHAR(100) COMMENT '类型'
);
INSERT INTO `collect_fees`(c_date,c_mileage,c_starting,c_remarks,c_type) VALUES 
( '0.7', '1.2', '12', '', '白天'),
( '0.8', '1.3', '12', '', '晚上'),
( '0.9', '1.4', '12', '', '周末'),
( '0.8', '1.2', '12', '', '节日假');

#10货主收藏信息表
CREATE TABLE s_collect(
c_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
s_phone VARCHAR(200) COMMENT '司机电话',
s_NAME VARCHAR(100) COMMENT '司机名字',
s_id INT COMMENT '收藏人id'
);
INSERT INTO `s_collect`(s_phone,s_NAME,s_id) VALUES 
 ( '1231331385', 'ZhangSan', '1'),
 ( '1257751385', 'ZhangSan', '2'),
 ( '1236655385', 'ZhangSan', '3'),
 ( '6541531385', 'ZhangSan', '4'),
 ( '1231334512', 'LiSi', '5'),
 ( '1237891385', 'ZhangSan', '6'),
 ( '1237831385', 'WangWu', '7'),
 ( '1231331385', 'ZhangSan', '8'),
 ( '1467531385', 'ZhangSan', '9'),
 ( '1575457385', 'ZhangSan', '1');
#11订单表
CREATE TABLE order_info(
o_id VARCHAR(50) PRIMARY KEY COMMENT '订单编号',
o_type INT COMMENT '车辆类型ID',
o_contacts VARCHAR(50) COMMENT '联系人',
o_start_date DATETIME COMMENT '预约时间',
o_end_date DATETIME COMMENT '完成时间',
o_price DECIMAL(10,2) COMMENT '订单价格',
o_shipping_address VARCHAR(100) COMMENT '发货地址',
o_receiving_address VARCHAR(100) COMMENT '收货地址',
s_id INT COMMENT '司机id',
d_id INT COMMENT '货主id',
o_state VARCHAR(50) COMMENT '订单状态',
o_remarks VARCHAR(256) COMMENT '备注'
);
INSERT INTO `order_info`(o_id,o_type,o_contacts,o_start_date,o_end_date,o_price,o_shipping_address,o_receiving_address,s_id,d_id,o_state,o_remarks) VALUES
 (  '1213123213','1', 'ZhouJielun', '2019-01-23', NULL, '200', '郑州市丰产路文化路', '湖北黄冈', '1', '2', '待运输',''),
 (  '1123123','2', 'ZhouJielun', '2019-01-23', NULL, '200', '郑州市丰产路文化路', '湖北黄冈', '2', '1', '运输中',''),
 (  '11232131312','3', 'ZhouJielun', '2019-01-23', '2019-01-26', '200', '郑州市丰产路文化路', '湖北黄冈', '3', '3', '已完成',''),
 ( '3123123121', '4', 'ZhouJielun', '2019-01-23', NULL, '200', '郑州市丰产路文化路', '湖北黄冈', '4', '2', '待运输', ''),
 ( '3213213211', '5', 'ZhouJielun', '2019-01-23', NULL, '200', '郑州市丰产路文化路', '湖北黄冈', '5', '2', '待运输', '');
#12评价信息表
CREATE TABLE evaluation_info(
e_id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
o_id VARCHAR(50) COMMENT '订单编号',
d_id INT COMMENT '司机id',
d_name  VARCHAR(50) COMMENT '货主名字',
s_id INT COMMENT '货主id',
s_name  VARCHAR(50) COMMENT '司机名字',
e_fraction VARCHAR(50) COMMENT '评价分数',
e_content VARCHAR(256) COMMENT '评价内容'
);
INSERT INTO `evaluation_info`(d_id,o_id ,d_name,s_id,s_name,e_fraction,e_content) VALUES
 ('1', '1213123213','adsa', '3' ,'tom', 5, '速度快,服务态度很好,棒棒哒'),
 ('2', '1123123','kim', '6' ,'jenny', 5, '速度快,服务态度很好,棒棒哒'),
 ('3','11232131312', 'res', '11' ,'DuHaixin', 4, '速度快,服务态度很好,棒棒哒'),
 ('4','3123123121', 'oppo', '14' ,'Liujiamei', 4, '速度快,服务态度很好,棒棒哒'),
 ('5','1123123', 'xin', '9' ,'ShiFuming', 5, '速度快,服务态度很好,棒棒哒'),
 ('6',  '3213213211','xin','3' ,'tom', 4.5, '速度快,服务态度很好,棒棒哒'),
 ('7', '3212133212', 'xin','3' ,'tom', 5, '速度快,服务态度很好,棒棒哒');
#13定位信息
CREATE TABLE locate_info(
l_id INT AUTO_INCREMENT PRIMARY KEY ,
l_add_name VARCHAR(100) COMMENT '开始地址',
l_end_name VARCHAR(100) COMMENT '目的地',
l_add_ip VARCHAR(100) ,
l_end_ip VARCHAR(100) ,
l_price DECIMAL(10,2) COMMENT '订单价格',
l_type INT ,
l_pei_yong VARCHAR(100),
l_pei_yongs VARCHAR(100)
);
INSERT INTO locate_info(l_add_name,l_add_ip,l_type)VALUES
('北京市','116.405285,39.904989',1),('天津市','117.190182,39.125596',0),('河北省','114.502461,38.045474',0),('山西省','112.549248,37.857014',0),('内蒙古自治区','111.670801,40.818311',0),('辽宁省','123.429096,41.796767',0),('吉林省','125.3245,43.886841',0),('黑龙江省','126.642464,45.756967',0),('上海市','121.472644,31.231706',0),('江苏省','118.767413,32.041544',0),('浙江省','120.153576,30.287459',0),('安徽省','117.283042,31.86119',0),('福建省','119.306239,26.075302',0),('江西省','115.892151,28.676493',0),('山东省','117.000923,36.675807',0),('河南省','113.665412,34.757975',0),('湖北省','114.298572,30.584355',0),('湖南省','112.982279,28.19409',0),('广东省','113.280637,23.125178',0),('广西壮族自治区','108.320004,22.82402',0),('海南省','110.33119,20.031971',0),('重庆市','106.504962,29.533155',0),('四川省','104.065735,30.659462',0),('贵州省','106.713478,26.578343',0),('云南省','102.712251,25.040609',0),('西藏自治区','91.132212,29.660361',0),('陕西省','108.948024,34.263161',0),('甘肃省','103.823557,36.058039',0),('青海省','101.778916,36.623178',0),('宁夏回族自治区','106.278179,38.46637',0),('新疆维吾尔自治区','87.617733,43.792818',0),('台湾省','121.509062,25.044332',0),('香港特別行政區','114.173355,22.320048',0),('澳門特別行政區','113.54909,22.198951',0);

