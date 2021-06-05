import SwiftUI
import Weather

struct RootView: View {
    @ObservedObject
    private var routerStates: ObservableValue<RouterState<AnyObject, WeatherRootChild>>
    
    init(_ component: TodoRoot) {
        self.routerStates = ObservableValue(component.routerState)
    }
    
    var body: some View {
        let child = self.routerStates.value.activeChild.instance
        
        switch child {
        case let main as WeatherRootChild.Main:
            MainView(main.component)
//
//         case let edit as WeatherRootChild.Edit:
//             EditView(edit.component)
//                 .transition(
//                     .asymmetric(
//                         insertion: AnyTransition.move(edge: .trailing),
//                         removal: AnyTransition.move(edge: .trailing)
//                     )
//                 )
//                 .animation(.easeInOut)
//
        default: EmptyView()
        }
    }
}

struct RootView_Previews: PreviewProvider {
    static var previews: some View {
        RootView(StubTodoRoot())
    }
    
    class StubWeatherRoot : WeatherRoot {
        let routerState: Value<RouterState<AnyObject, WeatherRootChild>> =
            simpleRouterState(WeatherRootChild.Main(component: MainView_Previews.StubTodoMain()))
    }
}
