package com.luvsea.blog.common.shiro;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.ExecutionException;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class MySubject implements Subject {

    @Override
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        new Md5Hash();
        new Md5Hash("", "");
        return null;
    }

    @Override
    public PrincipalCollection getPrincipals() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPermitted(String permission) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPermitted(Permission permission) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean[] isPermitted(String... permissions) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean[] isPermitted(List<Permission> permissions) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPermittedAll(String... permissions) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPermittedAll(Collection<Permission> permissions) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void checkPermission(String permission) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkPermission(Permission permission) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkPermissions(String... permissions) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkPermissions(Collection<Permission> permissions) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean hasRole(String roleIdentifier) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean[] hasRoles(List<String> roleIdentifiers) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasAllRoles(Collection<String> roleIdentifiers) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void checkRole(String roleIdentifier) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkRoles(Collection<String> roleIdentifiers) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void checkRoles(String... roleIdentifiers) throws AuthorizationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void login(AuthenticationToken token) throws AuthenticationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isAuthenticated() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isRemembered() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Session getSession() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Session getSession(boolean create) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <V> V execute(Callable<V> callable) throws ExecutionException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void execute(Runnable runnable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <V> Callable<V> associateWith(Callable<V> callable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Runnable associateWith(Runnable runnable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void runAs(PrincipalCollection principals) throws NullPointerException, IllegalStateException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isRunAs() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public PrincipalCollection getPreviousPrincipals() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PrincipalCollection releaseRunAs() {
        // TODO Auto-generated method stub
        return null;
    }

}
