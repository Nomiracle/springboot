package SpringCore.SpringAOPAspectJAroundAnnotation;

import SpringCore.SpringStaticfactory.EmployeeDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* SpringCore.SpringAOPAspectJAroundAnnotation.EmployeeManagerImpl.*(..))")
    public EmployeeDTO logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        EmployeeDTO employee = new EmployeeDTO();
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have

            employee.setId(2);
            employee.setFirstName("bbbb");
            employee.setDesignation("bbbb");
            employee.setLastName("bbbb");

        }
        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": After Method Execution");
        return employee;
    }

    @Around("execution(* SpringCore.SpringAOPAspectJAroundAnnotation.EmployeeManagerImpl.getEmployeeById(..))")
    public void logAroundGetEmployee(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("****LoggingAspect.logAroundGetEmployee() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        try {
            //joinPoint.proceed();
        } finally {
            //Do Something useful, If you have

        }
        System.out.println("****LoggingAspect.logAroundGetEmployee() : " + joinPoint.getSignature().getName() + ": After Method Execution");
    }

    @Around("execution(* SpringCore.SpringAOPAspectJAroundAnnotation.EmployeeManagerImpl.createEmployee(..))")
    public void logAroundCreateEmployee(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("****LoggingAspect.logAroundCreateEmployee() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("****LoggingAspect.logAroundCreateEmployee() : " + joinPoint.getSignature().getName() + ": After Method Execution");
    }
}
