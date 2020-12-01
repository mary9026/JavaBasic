-- ���̺� ����
CREATE table shoping (
	ordno int,
	orddate datetime,
	prodname char(5),
	saleprice int
);

-- �� ���̺�
CREATE table customers (
	cusid varchar(16) primary key, -- primary key ���̵� �ߺ������Ͱ� ���°� ������
	cusname varchar(10),
	age int,
	grade varchar(10),
	job varchar(10),
	bonus int
);

-- ��ǰ ���̺�
CREATE table products (
	prodno char(4) primary key,
	prdname varchar(10),
	stock int,
	price int,
	prdmaker varchar(10) 
);

-- �ֹ� ���̺�
CREATE table orders (
	ordno int primary key,
	cusid varchar(16), -- �����̺� ������ ���� (pk)
	prodno char(4), -- ��ǰ ���̺� ������ ���� (pk)
	qty int,
	addr varchar(20),
	orddate datetime
);

-- �ܷ�Ű ����
-- foreign key (�÷���)
-- references ���̺��(�÷���);

-- �ֹ� <-> �� ���̺� ���� ����
-- �ֹ� <-> ��ǰ ���̺� ���� ����

CREATE table orders2 ( -- �ֹ� / �� �ܷ�Ű ����
	ordno int primary key,
	cusid varchar(16), -- �����̺� ������ ���� (pk)
	prodno char(4), -- ��ǰ ���̺� ������ ���� (pk)
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (cusid)
	references customers (cusid)
);

CREATE table orders3 ( -- �ֹ� / ��ǰ �ܷ�Ű ����
	ordno int primary key,
	cusid varchar(16), -- �����̺� ������ ���� (pk)
	prodno char(4), -- ��ǰ ���̺� ������ ���� (pk)
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (prodno)
	references products (prodno)
);

CREATE table orders4 ( -- �ֹ� / ��, ��ǰ �ܷ�Ű ����
	ordno int primary key,
	cusid varchar(16), -- �����̺� ������ ���� (pk)
	prodno char(4), -- ��ǰ ���̺� ������ ���� (pk)
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (cusid)
	references customers (cusid),
	foreign key (prodno)
	references products (prodno)
);

-- ��, �ܷ�Ű ������ ������
-- ���̺� ���������� �����ؾ� ��!
-- �� -> ��ǰ -> �ֹ�  