package com.springboot.actualcombat.springconfigure.scope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Future
 */
@Service
@Scope(value = "prototype")
public class PrototypeService {

}
