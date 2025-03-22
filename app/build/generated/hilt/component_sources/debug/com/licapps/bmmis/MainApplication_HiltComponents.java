package com.licapps.bmmis;

import com.licapps.bmmis.di.AppModule;
import com.licapps.bmmis.ui.activities.LaunchActivity_GeneratedInjector;
import com.licapps.bmmis.ui.activities.NewHomeActivity_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.ActivisationFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.AnadaEMHRFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.AnandaFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.BOCFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.ClaimsFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.ContactUsFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.EMHRFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.HomeFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.InactiveResListFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.InactiveResourcesFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.LoginFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.MABDetailsFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.MABFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.NBChannelWiseFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.NBForDayFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.NBPerfUptoMonthFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.NBPerformanceFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.NUAFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.NewHomeFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.PeristenceFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.PlanPerfFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.ProspectiveNewFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.ProspectivesFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.ResourceBuildingFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.ResourceFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.SplashFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.TopPerformersFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.WebViewFragment_GeneratedInjector;
import com.licapps.bmmis.ui.fragments.WishesFragment_GeneratedInjector;
import com.licapps.bmmis.ui.viewmodels.ActivisationViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.AnandaViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.AvailResourceViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.BOCViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.CasesViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.ClaimsViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.EMHRViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.InactiveResListViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.InactiveViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.LoginViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.MABViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.NBChannelWiseViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.NBForDayViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.NBUptoDayViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.NBUptoMonthhViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.NUAViewmodel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.PersistenceViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.PlanPerfViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.ResBuildingViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.SplashViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.TopPerformersViewModel_HiltModules;
import com.licapps.bmmis.ui.viewmodels.WishesViewModel_HiltModules;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.inject.Singleton;

public final class MainApplication_HiltComponents {
  private MainApplication_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          AppModule.class,
          ApplicationContextModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements MainApplication_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          ActivisationViewModel_HiltModules.KeyModule.class,
          AnandaViewModel_HiltModules.KeyModule.class,
          AvailResourceViewModel_HiltModules.KeyModule.class,
          BOCViewModel_HiltModules.KeyModule.class,
          CasesViewModel_HiltModules.KeyModule.class,
          ClaimsViewModel_HiltModules.KeyModule.class,
          EMHRViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          InactiveResListViewModel_HiltModules.KeyModule.class,
          InactiveViewModel_HiltModules.KeyModule.class,
          LoginViewModel_HiltModules.KeyModule.class,
          MABViewModel_HiltModules.KeyModule.class,
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          NBChannelWiseViewModel_HiltModules.KeyModule.class,
          NBForDayViewModel_HiltModules.KeyModule.class,
          NBUptoDayViewModel_HiltModules.KeyModule.class,
          NBUptoMonthhViewModel_HiltModules.KeyModule.class,
          NUAViewmodel_HiltModules.KeyModule.class,
          PersistenceViewModel_HiltModules.KeyModule.class,
          PlanPerfViewModel_HiltModules.KeyModule.class,
          ResBuildingViewModel_HiltModules.KeyModule.class,
          SplashViewModel_HiltModules.KeyModule.class,
          TopPerformersViewModel_HiltModules.KeyModule.class,
          WishesViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class,
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements LaunchActivity_GeneratedInjector,
      NewHomeActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          ActivisationViewModel_HiltModules.BindsModule.class,
          AnandaViewModel_HiltModules.BindsModule.class,
          AvailResourceViewModel_HiltModules.BindsModule.class,
          BOCViewModel_HiltModules.BindsModule.class,
          CasesViewModel_HiltModules.BindsModule.class,
          ClaimsViewModel_HiltModules.BindsModule.class,
          EMHRViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          InactiveResListViewModel_HiltModules.BindsModule.class,
          InactiveViewModel_HiltModules.BindsModule.class,
          LoginViewModel_HiltModules.BindsModule.class,
          MABViewModel_HiltModules.BindsModule.class,
          NBChannelWiseViewModel_HiltModules.BindsModule.class,
          NBForDayViewModel_HiltModules.BindsModule.class,
          NBUptoDayViewModel_HiltModules.BindsModule.class,
          NBUptoMonthhViewModel_HiltModules.BindsModule.class,
          NUAViewmodel_HiltModules.BindsModule.class,
          PersistenceViewModel_HiltModules.BindsModule.class,
          PlanPerfViewModel_HiltModules.BindsModule.class,
          ResBuildingViewModel_HiltModules.BindsModule.class,
          SplashViewModel_HiltModules.BindsModule.class,
          TopPerformersViewModel_HiltModules.BindsModule.class,
          WishesViewModel_HiltModules.BindsModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements ActivisationFragment_GeneratedInjector,
      AnadaEMHRFragment_GeneratedInjector,
      AnandaFragment_GeneratedInjector,
      BOCFragment_GeneratedInjector,
      ClaimsFragment_GeneratedInjector,
      ContactUsFragment_GeneratedInjector,
      EMHRFragment_GeneratedInjector,
      HomeFragment_GeneratedInjector,
      InactiveResListFragment_GeneratedInjector,
      InactiveResourcesFragment_GeneratedInjector,
      LoginFragment_GeneratedInjector,
      MABDetailsFragment_GeneratedInjector,
      MABFragment_GeneratedInjector,
      NBChannelWiseFragment_GeneratedInjector,
      NBForDayFragment_GeneratedInjector,
      NBPerfUptoMonthFragment_GeneratedInjector,
      NBPerformanceFragment_GeneratedInjector,
      NUAFragment_GeneratedInjector,
      NewHomeFragment_GeneratedInjector,
      PeristenceFragment_GeneratedInjector,
      PlanPerfFragment_GeneratedInjector,
      ProspectiveNewFragment_GeneratedInjector,
      ProspectivesFragment_GeneratedInjector,
      ResourceBuildingFragment_GeneratedInjector,
      ResourceFragment_GeneratedInjector,
      SplashFragment_GeneratedInjector,
      TopPerformersFragment_GeneratedInjector,
      WebViewFragment_GeneratedInjector,
      WishesFragment_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
