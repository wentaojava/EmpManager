package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Entity.Emp;

public class EmpDao implements Serializable {
	public List<Emp> findAll(){
		//ģ���ѯ����Ա��
		List<Emp> list=new ArrayList<Emp>();
		
		Emp e1=new Emp();
		e1.setEmpno(1);
		e1.setName("����");
		e1.setJob("����1");
		e1.setSal(1000.0);
		list.add(e1);
		
		Emp e2=new Emp();
		e2.setEmpno(2);
		e2.setName("����");
		e2.setJob("����2");
		e2.setSal(2000.0);
		list.add(e2);
		
		Emp e3=new Emp();
		e3.setEmpno(3);
		e3.setName("����");
		e3.setJob("����3");
		e3.setSal(5000.0);
		list.add(e3);
		
		return list;
		
	}

}
