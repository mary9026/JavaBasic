-- 테이블 생성
CREATE table shoping (
	ordno int,
	orddate datetime,
	prodname char(5),
	saleprice int
);

-- 고객 테이블
CREATE table customers (
	cusid varchar(16) primary key, -- primary key 아이디 중복데이터가 들어가는걸 막아줌
	cusname varchar(10),
	age int,
	grade varchar(10),
	job varchar(10),
	bonus int
);

-- 제품 테이블
CREATE table products (
	prodno char(4) primary key,
	prdname varchar(10),
	stock int,
	price int,
	prdmaker varchar(10) 
);

-- 주문 테이블
CREATE table orders (
	ordno int primary key,
	cusid varchar(16), -- 고객테이블 정보랑 동일 (pk)
	prodno char(4), -- 상품 테이블 정보랑 동일 (pk)
	qty int,
	addr varchar(20),
	orddate datetime
);

-- 외래키 설정
-- foreign key (컬럼명)
-- references 테이블명(컬럼명);

-- 주문 <-> 고객 테이블간 관계 설정
-- 주문 <-> 상품 테이블간 관계 설정

CREATE table orders2 ( -- 주문 / 고객 외래키 설정
	ordno int primary key,
	cusid varchar(16), -- 고객테이블 정보랑 동일 (pk)
	prodno char(4), -- 상품 테이블 정보랑 동일 (pk)
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (cusid)
	references customers (cusid)
);

CREATE table orders3 ( -- 주문 / 상품 외래키 설정
	ordno int primary key,
	cusid varchar(16), -- 고객테이블 정보랑 동일 (pk)
	prodno char(4), -- 상품 테이블 정보랑 동일 (pk)
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (prodno)
	references products (prodno)
);

CREATE table orders4 ( -- 주문 / 고객, 상품 외래키 설정
	ordno int primary key,
	cusid varchar(16), -- 고객테이블 정보랑 동일 (pk)
	prodno char(4), -- 상품 테이블 정보랑 동일 (pk)
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (cusid)
	references customers (cusid),
	foreign key (prodno)
	references products (prodno)
);

-- 단, 외래키 설정할 때에는
-- 테이블 생성순서에 주의해야 함!
-- 고객 -> 상품 -> 주문  