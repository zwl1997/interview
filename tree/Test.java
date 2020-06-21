package suanfa.tree;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Permission> permissionTree = new ArrayList<>();

        Permission p1 = new Permission(1,"系统菜单",0);
        Permission p2 = new Permission(2,"控制面板",1);
        Permission p3 = new Permission(3,"用户维护",1);
        Permission p4 = new Permission(4,"增加用户",3);
        Permission p5 = new Permission(5,"修改用户",3);

        List<Permission> permissions = new ArrayList<>();
        permissions.add(p1);
        permissions.add(p2);
        permissions.add(p3);
        permissions.add(p4);
        permissions.add(p5);

        for (Permission permission : permissions) {
            Permission child = permission;
            if(permission.getPid() == 0){
                permissionTree.add(permission);
            }else{
                for (Permission permission1 : permissions) {
                    if(child.getPid().equals(permission1.getId())){
                        Permission parent = permission1;
                        parent.getChildren().add(child);
                    }
                }
            }
        }

        System.out.println(permissionTree);
    }
}
