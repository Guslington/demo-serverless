CfhighlanderTemplate do
  Name 'demo'

  Component template: 'vpc@1.3.0', name: 'vpc'
  Component template: 'loadbalancer@1.0.0', name: 'loadbalancer'
  Component template: 'bastion@1.2.0', name: 'bastion'
  Component template: 'ecs@1.1.1', name: 'ecs'

  addMapping('EnvironmentType',{
      'development' => {
          'MaxNatGateways'=>'1',
          'EcsAsgMin' => 1,
          'EcsAsgMax' => 1,
          'EcsInstanceType' => 't2.small',
          'BastionInstanceType'=>'t2.micro',
          'SingleNatGateway' => true
      }
  })

end